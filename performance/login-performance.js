import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
    vus: 5,
    duration: '10s',

    thresholds: {
        http_req_duration: ['p(95)<1000'],
        http_req_failed: ['rate<0.05'],
    },
};

export default function () {

    const payload = JSON.stringify({
        usuario: 'admin',
        contrasena: '1234'
    });

    const params = {
        headers: {
            'Content-Type': 'application/json'
        }
    };

    const respuesta = http.post(
        'http://localhost:8080/login',
        payload,
        params
    );

    check(respuesta, {
        'login responde 200': (r) => r.status === 200,
        'latencia menor a 1 segundo': (r) => r.timings.duration < 1000,
    });

    sleep(1);
}