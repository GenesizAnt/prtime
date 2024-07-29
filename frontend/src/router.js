import {createRouter, createWebHistory} from 'vue-router';
import WelcomePage from "@/components/WelcomePage";
import AllReceptionPage from "@/components/AllReceptionPage";
import ReceptionPage from "@/components/ReceptionPage";
import CreateReceptionPage from "@/components/CreateReceptionPage";
import NotFound from "@/components/NotFound";

const routes = [
    {
        path: '/',
        name: 'home',
        component: WelcomePage
    },
    {
        path: '/allReceptionPage',
        name: 'allReception',
        component: AllReceptionPage
    },
    {
        path: '/createReception',
        name: 'newReception',
        component: CreateReceptionPage
    },
    {
        path: '/reception/:id',
        name: 'reception',
        component: ReceptionPage,
        props: true
    },
    {
        path: '/:notFound(.*)',
        name: 'notFound',
        component: NotFound
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router