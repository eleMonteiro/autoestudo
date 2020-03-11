<template>
  <v-card>
    <v-card-title>
      Nutrition
      <v-spacer></v-spacer>
      <v-text-field
        v-model="search"
        append-icon="mdi-magnify"
        label="Search"
        single-line
        hide-details
      ></v-text-field>
    </v-card-title>
    <v-data-table :headers="headers" :items="usuarios" :items-per-page="5"
              class="elevation-1" :search="search"></v-data-table>
  </v-card>
</template>

<script>
import VCardWidget from "@/components/VWidget";
import { RepositoryFactory } from "@/repositories/RepositoryFactory";
const usuarioRepo = RepositoryFactory.get("usuario");

export default {
  name: "home",
  components: {
    VCardWidget
  },

  data: () => ({
    headers: [
      {
        text: "Nome",
        align: "start",
        sortable: false,
        value: "nome"
      },
      { text: "Email", value: "email" },
      { text: "Habilitado", value: "habilitado" },
      {
        text: "",
        align: "start",
        sortable: false
      },
    ],
    usuarios: [],
    search: ''
  }),

   created() {
    usuarioRepo
      .getAll()
      .then(res => {
        this.usuarios = res.data;
      })
      .catch(console.error);
  },

  computed: {},

  methods: {
    redirect() {
      this.$router.push('/cadastro')
    }
  }
};
</script>