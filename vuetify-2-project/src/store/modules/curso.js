import axios from 'axios'
import auth from './auth';


// state
const state = {
    curso: ''
};

// actions
const actions = {
    cadastrar({ commit, dispatch }, cursoData) {
        axios.post('cursos/cadastrar', {
                nome: cursoData.nome, 
                sigla: cursoData.sigla,
                turno: {turno: cursoData.turno}
            }, { headers: {Authorization: auth.state.token }})
             .then(res => {commit('CLEAN')})
             .catch(error => console.log(error))
             .finally(() => resolve())
    },
    editar({ commit, dispatch }, cursoData) {
        axios.put(`cursos/editar/${cursoData.id}`, {
                id: cursoData.id,
                nome: cursoData.nome, 
                sigla: cursoData.sigla,
                turno: {
                    turno: cursoData.turno
                }
            }, { headers: {Authorization: auth.state.token }})
             .then(res => {commit('CLEAN')})
             .catch(error => console.log(error))
             .finally(() => resolve())
    },
    excluir({commit, dispatch}, id){
        axios.delete(`cursos/deletar/${id}`,{headers: {Authorization: auth.state.token }})
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