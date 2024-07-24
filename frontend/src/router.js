import { createRouter, createWebHistory } from 'vue-router';
import WelcomePage from "@/components/WelcomePage";
import AllReceptionPage from "@/components/AllReceptionPage";
import ReceptionPage from "@/components/ReceptionPage";
import CreateReceptionPage from "@/components/CreateReceptionPage";
import NotFound from "@/components/NotFound";

//ToDO сделать роутер отдельным классом

const routes = [
    { path: '/', component: WelcomePage },
    { path: '/allReceptionPage', component: AllReceptionPage },
    { path: '/createReception', component: CreateReceptionPage},
    { path: '/reception/:id', name: 'ReceptionPage', component: ReceptionPage},
    { path: '/:notFound(.*)', component: NotFound }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router