import { createApp } from 'vue'
import App from './App.vue'
import { createRouter, createWebHistory } from 'vue-router';
import WelcomePage from "@/components/WelcomePage";
import AllReceptionPage from "@/components/AllReceptionPage";
import ReceptionPage from "@/components/ReceptionPage";
import CreateReceptionPage from "@/components/CreateReceptionPage";
// import AddProductComponent from './components/AddProductComponent.vue';

const routes = [
    { path: '/', component: WelcomePage },
    { path: '/allReceptionPage', component: AllReceptionPage },
    { path: '/createReception', component: CreateReceptionPage},
    { path: '/reception/:id',
        name: 'ReceptionPage',
        component: ReceptionPage},
    // { path: '/receptionPage', component: ReceptionPage}
    // { path: '/add-product', component: AddProductComponent }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

const app = createApp(App);
app.use(router);
app.mount('#app');
