import Vuex from 'vuex';

const state = {
    token: localStorage.getItem('user-token') || '',
    role: localStorage.getItem('user-role') || '',
    username: localStorage.getItem('user-name') || '',
    authorities: localStorage.getItem('authorities') || '',
};

const getters = {
    isAuthenticated: state => {
        return state.token != null && state.token !== '';
    },
    isAdmin: state => {
        return state.role === 'admin';
    },
    getUsername: state => {
        return state.username;
    },
    getAuthorities: state => {
        console.log(state)
        return state.role;
    },
    getToken: state => {
        return state.token;
    }
};

const mutations = {
    auth_login: (state, user) => {
        localStorage.setItem('user-token', user.token);
        localStorage.setItem('user-name', user.name);
        localStorage.setItem('user-authorities', user.roles);
        state.token = user.token;
        state.username = user.username;
        state.authorities = user.roles;
        let isUser = false;
        let isAdmin = false;
        for (var i = 0; i < user.roles.length; i++) {
            if (user.roles[i].authority === 'ROLE_USER') {
                isUser = true;
            } else if (user.roles[i].authority === 'ROLE_ADMIN') {
                isAdmin = true;
            }
        }
        if (isUser) {
            localStorage.setItem('user-role', 'user');
            state.role = 'user';
        }
        if (isAdmin) {
            localStorage.setItem('user-role', 'admin');
            state.role = 'admin';
        }
    },
    auth_logout: () => {
        state.token = '';
        state.role = '';
        state.username = '';
        state.authorities = [];
        localStorage.removeItem('user-token');
        localStorage.removeItem('user-role');
        localStorage.removeItem('user-name');
        localStorage.removeItem('user-authorities');
    }
};

const actions = {
    login: (context, user) => {
        context.commit('auth_login', user)
    },
    logout: (context) => {
        context.commit('auth_logout');
    }
};

export const store = new Vuex.Store({
    state,
    getters,
    mutations,
    actions
});