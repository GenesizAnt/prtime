import { createApp } from 'vue'
import App from './App.vue'
import router from "@/router";
import axios from "axios";
import {store} from "@/store";

const app = createApp(App);
app.use(router);
app.use(store);
app.mount('#app');

axios.interceptors.request.use(config => {
    const token = localStorage.getItem('token');
    if (token) {
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
});

