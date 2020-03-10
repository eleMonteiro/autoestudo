import store from '../store'
import LoginPage from '../views/Login'
import Home from '../views/Home'
import CadastroUsuario from '../views/usuario/Cadastro'
import EditarUsuario from '../views/usuario/Editar'
import ListarUsuarios from '../views/usuario/Lista'

import CadastroCurso from '../views/cursos/Cadastro'
import EditarCurso from '../views/cursos/Editar'
import ListarCursos from '../views/cursos/Lista'

export default [


    /* Geral */
    {
        path: '/',
        name: 'Home',
        component: Home
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
    /* Usuarios */
    {
        path: '/usuarios/cadastro',
        name: 'Cadastro',
        component: CadastroUsuario
    },
    {
        path: '/usuarios/editar',
        name: 'Editar',
        component: EditarUsuario
    },
    {
        path: '/usuarios/listar',
        name: 'Listar',
        component: ListarUsuarios
    },

    /* Cursos */
    {
        path: '/cursos/cadastro',
        name: 'Cadastro',
        component: CadastroCurso
    },
    {
        path: '/cursos/editar',
        name: 'Editar',
        component: EditarCurso
    },
    {
        path: '/cursos/listar',
        name: 'Listar',
        component: ListarCursos
    },
];
