<template>
<div class="container">
    <h1>Agregar un libro</h1>
    <form>
        <div class="form-item">
            <label for="name">Nombre</label>
            <input type="text" id="name" v-model="newBook.name">
        </div>
        <div>
            <button type="button" @click="send" class="main">Crear</button>
        </div>
        <div class="info">
            <h2>Objeto</h2>
            <code>{{newBook}}</code>
            <p class="message">
                {{message}}
            </p>
        </div>
    </form>

</div>
</template>
<script>
export default {
    data(){
        return{
            message:'',
            newBook:{}
        }
    },
    methods:{
        send:async function(){
            this.message = '';
            //validaciones de formulario
            if (this.newBook.name == ''){
                this.message = 'Debes ingresar un nombre'
                return false
            }
            //envío de datos del formulario
            try {
                var result = await this.$axios.post('/books', this.newBook);
                let book = result.data;
                //mensaje de exito 
                this.message = `Se creó un nuevo libro con id: ${book.id}`;
                this.newBook = {};
            } catch (error) {
                //mensaje de error
                console.log('error', error)
                this.message = 'Ocurrió un error'
            }
        }
    }
}
</script>
<style>
code{
    padding: .5rem 1rem;
    color:white;
    background:#444;
    font-size: 1rem;
    width: 100%;
    display:inline-block;
}
p.message{
    border:solid 1px rgba(0,0,0,0.25);
    padding: .5rem 1rem;
    font-weight: bold;
}
</style>