import { createApp } from 'vue'
import App from './App.vue'
import { createRouter, createWebHistory } from 'vue-router';
import WelcomePage from "@/components/WelcomePage";
import ReceptionPage from "@/components/ReceptionPage";
import CreateReceptionPage from "@/components/CreateReceptionPage";
// import AddProductComponent from './components/AddProductComponent.vue';

const routes = [
    { path: '/', component: WelcomePage },
    { path: '/receptionPage', component: ReceptionPage },
    { path: '/createReception', component: CreateReceptionPage}
    // { path: '/add-product', component: AddProductComponent }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

const app = createApp(App);
app.use(router);
app.mount('#app');
