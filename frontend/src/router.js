import {createRouter, createWebHistory} from 'vue-router';
import WelcomePage from "@/components/WelcomePage";
import AllReceptionPage from "@/components/AllReceptionPage";
import ReceptionPage from "@/components/ReceptionPage";
import CreateReceptionPage from "@/components/CreateReceptionPage";
import NotFound from "@/components/NotFound";
import LoginPage from "@/components/LoginPage.vue";
import AdminPage from "@/components/AdminPage.vue";
import HomePage from "@/components/HomePage.vue";
import LoginPage from "@/components/LoginPage.vue";
import RegisterPage from "@/components/RegisterPage.vue";

const routes = [
    {
        path: '/',
        name: 'home',
        component: WelcomePage
    },
    {
        path: '/login',
        name: 'LoginPage',
        component: LoginPage
    },
    {
        path: '/register',
        name: 'RegisterPage',
        component: RegisterPage
    },
    {
        path: '/admin',
        name: 'AdminPage',
        component: AdminPage
    },
    {
        path: '/home',
        name: 'HomePage',
        component: HomePage
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

// Добавляем навигационный guard для проверки аутентификации
router.beforeEach((to, from, next) => {
    const isAuthenticated = localStorage.getItem("jwtToken"); // Проверяем наличие токена
    if (to.meta.requiresAuth && !isAuthenticated) {
        next("/receptions/api/auth/login"); // Перенаправляем на страницу входа, если пользователь не авторизован
    } else {
        next(); // Продолжаем навигацию
    }
});

export default router