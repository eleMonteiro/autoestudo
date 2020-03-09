import store from '../store'
import LoginPage from '../views/Login'
import Home from '../views/Home'
import Cadastro from '../views/usuario/Cadastro'
import Editar from '../views/usuario/Editar'

export default [


    /* Geral */
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/cadastro',
        name: 'Cadastro',
        component: Cadastro
    },
    {
        path: '/editar',
        name: 'Editar',
        component: Editar
    },
    {
        path: '/login',
        meta: {
            public: true,
        },
        props: true,
        name: 'Login',
        component: LoginPage
    },

    {
        path: '/logout',
        meta: { breadcrumb: true },
        name: 'Logout',
        beforeEnter (to, from, next) {
            store.dispatch('auth/logout', false)
        }
    },

];
