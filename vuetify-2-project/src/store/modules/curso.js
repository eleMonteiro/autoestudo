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
                turno: cursoData.turno
            }, { headers: {Authorization: auth.state.token }})
             .catch(error => console.log(error))
             .finally(() => resolve())
    },
    editar({ commit, dispatch }, cursoData) {
        axios.put(`cursos/editar/${cursoData.id}`, {
                id: cursoData.id,
                nome: cursoData.nome, 
                sigla: cursoData.sigla,
                turno: cursoData.turno                
            }, { headers: {Authorization: auth.state.token }})
             .catch(error => console.log(error))
             .finally(() => resolve())
    },
    excluir({commit, dispatch}, id){
        axios.delete(`cursos/deletar/${id}`,{headers: {Authorization: auth.state.token }})
         .catch(error => console.log(error))
         .finally(() => resolve())
    }
};

// getters
const getters = {
    getCurso(state){
        return state.curso;
    }
};

// mutations
const mutations = {
    setCurso(state, curso){
        state.curso = curso;
    }
};

export default {
    namespaced: true,
    state,
    mutations,
    actions,
    getters
}