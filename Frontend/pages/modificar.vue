<template>
  <div>
    <h1>Editar libro</h1>
    <v-row align="center">
      <v-col cols="12">
        <v-select
          :items="libros"
          :menu-props="{ top: true, offsetY: true }"
          label="Label"
        ></v-select>
      </v-col>
    </v-row>
  </div>
</template>



<script>
import axios from "axios";

export default {
  data() {

    return {
      libros = [], //Aqui se guardaran los libros de la base da datos para modificar
      message: "",
      newBook: {
        titulo: '',
        autor: '',
        editorial: '',
        paginas: '',
        precio: '',
        volumen: ''
      },
    };
  },
  methods: {
    //Función asíncrona para consultar los datos
    getData: async function () {
      try {
        let response = await this.$axios.get("/books");
        this.libros = response.data;
        console.log(response);
      } catch (error) {
        console.log("error", error);
      }
    },
    handleSubmitForm() {
                let apiURL = 'http://localhost:8080/books/update/{id}';
                axios.post(apiURL, {
                    titulo : this.newBook.titulo,
                    autor : this.newBook.autor,
                    editorial : this.newBook.editorial,
                    paginas : this.newBook.paginas,
                    precio : this.newBook.precio,
                    volumen : this.newBook.volumen
                    }).then(res => {
                    this.respuesta = res.data;
                    alert(this.respuesta);
        
                }).catch(error => {
                    alert(error)
                    console.log(error)
                });
            },
  },
  //Función que se ejecuta al cargar el componente
  created: function () {
    this.getData();
  },
};
</script>

<style lang="scss" scoped>
</style>