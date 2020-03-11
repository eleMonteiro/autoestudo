<template>
  <v-card-widget enableActions :title="'Editar Usuário'">
    <div slot="widget-header-action"></div>
    <div slot="widget-content">
      <template>
        <v-form @submit.prevent="onSubmit" ref="form" lazy-validation v-model="valid">
          <v-container>
            <v-col cols="12" md="4">
              <v-text-field v-model="curso.id" disabled></v-text-field>
            </v-col>
            <v-row>
              <v-col cols="12" md="4">
                <v-text-field v-model="curso.nome" label="Nome" required :rules="requiredRule"></v-text-field>
              </v-col>
              <v-col cols="12" md="4">
                <v-text-field v-model="curso.sigla" label="Sigla" required :rules="requiredRule"></v-text-field>
              </v-col>
              <v-col class="d-flex" cols="12" md="4">
                <v-select
                  :items="turnos"
                  v-model="curso.turno"
                  :aria-selected="curso.turno"
                  label="Turnos"
                  dense
                ></v-select>
              </v-col>
            </v-row>
            <v-row>
              <div class="my-2">
                <v-btn color="primary" type="submit" :loading="loading" large>Editar</v-btn>
              </div>
            </v-row>
          </v-container>
        </v-form>
      </template>
    </div>
  </v-card-widget>
</template>
    
<script>
import VCardWidget from "@/components/VWidget";
import { mapGetters, mapState, mapMutations } from "vuex";
import { RepositoryFactory } from "@/repositories/RepositoryFactory";
import cursoStore from "../../store/modules/curso";

const usuarioRepo = RepositoryFactory.get("curso");

export default {
  name: "Cadastro",
  components: {
    VCardWidget
  },

  data: () => ({
    valid: true,
    loading: false,
    error: "",
    requiredRule: [v => !!v || "Campo obrigatório"],
    turnos: ["Manhã", "Tarde", "Noite"],
    curso: { id: "", nome: "", sigla: "", turno: "" },
  }),

  computed: {
    ...mapGetters({
      cursoStore: 'curso/getCurso'
    })
  },

  methods: {
    onSubmit() {
      this.loading = true;
      if (this.$refs.form.validate()) {
          this.$store.dispatch("curso/editar", this.curso).then(() => {
          this.$router.push("/cursos/listar");
        });
      }

      this.loading = false;
    }
  },

  mounted() {
    this.curso = this.cursoStore
    console.log(this.cursoStore)
  }

};
</script>