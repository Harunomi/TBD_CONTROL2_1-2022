<template>
    <div class="container">
        <h1>Eliminar Libro</h1>

        <form @submit.prevent="handleSubmitForm">
            <div class="form-item">
                <label>id del libro a eliminar</label>
                <input type="number" id="id" v-model="newBook.id" />
            </div>
            <div>
                <button type="submit" class="main" v-on:click="eliminar()">Eliminar</button>
            </div>
        </form>
    </div>
</template>

<script>
    import axios from "axios";
//falta lo importante para deletear XD
    export default {
        data() {
            return {
                message: "",
                newBook: {
                    id: ''
                },
            };
        },
        methods: {
            eliminar(){
                var deletear ={
                    "id": this.newBook.id
                };
                axios.delete('localhost:8080/books/delete/${id}',{ deletear})
                .then(dato => {
                    connsole.log(datos);
                });
            }
        },
        /*
        //Función asíncrona para consultar los datos
        ,
            delBook: async function(){
                try {
                    let response = await this.$axios.get('/books/delete/{id}');
                    this.items = response.data;
                    console.log(response)
                } catch (error) {
                    console.log('error', error);
                }
            }
       */
        //Función que se ejecuta al cargar el componente
       /*
        created: function () {
            this.handleSubmitForm();
        }*/
    }
</script>