import axios from 'axios'
import auth from './auth';


// state
const state = {

};

// actions
const actions = {
    cadastrar({ commit, dispatch }, userData) {
        axios.post('usuarios/cadastro', {
                nome: userData.nome, 
                email: userData.email, 
                password: userData.password,
                habilitado: userData.habilitado
            }, { headers: {Authorization: auth.state.token }})
             .then(res => {commit('CLEAN')})
             .catch(error => console.log(error))
             .finally(() => resolve())

    },
    editar({ commit, dispatch }, userData) {
        axios.post('usuarios/editar', {
                nome: userData.nome, 
                email: userData.email, 
                password: userData.password,
                habilitado: userData.habilitado
            }, { headers: {Authorization: auth.state.token }})
             .then(res => {commit('CLEAN')})
             .catch(error => console.log(error))
             .finally(() => resolve())
    },
    excluir({commit, dispatch}, id){
        axios.post(`usuarios/excluir/${id}`,{headers: {Authorization: auth.state.token }})
         .then(res => {})
         .catch(error => console.log(error))
         .finally(() => resolve())
    }
};

// getters
const getters = {

};

// mutations
const mutations = {
    CLEAN: (state) => {
       
    }
};

export default {
    namespaced: true,
    state,
    mutations,
    actions,
    getters
}