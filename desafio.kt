// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { INICIANTE, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val email: String, val senha: String)

data class ConteudoEducacional(val nome: String, val nivel: Nivel)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    val viewinscritos: List<Usuario> = inscritos  
    
    //Matricular um usuario
    fun matricular(usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        inscritos.add(usuario)
    }
    
    //Matricular varios usuarios
    fun matricular(vararg usuario: Usuario) {
        for (user in usuario) inscritos.add(user)
    }
    
    //Iterator para listar os conteudos
    operator fun iterator(): Iterator<ConteudoEducacional> {            
        return conteudos.iterator()                          
    }
    
    //Função para listar os inscritos
    fun getInscrito(): List<Usuario> {                                 
    	return viewinscritos
	}
}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    
    //Criando usuario
    val usuario = Usuario("Nara", "edy@gmail.com", "Nara123")
    val usuario2 = Usuario("João", "joao@gmail.com", "Joao123")
    val usuario3 = Usuario("Ana", "ana@gmail.com", "Ana123")
    
    //Criando conteudos educacionais
    val conteudo1 = ConteudoEducacional("Documentação Oficial Kotlin", Nivel.INICIANTE)
    val conteudo2 = ConteudoEducacional("Estruturas de controle de fluxo e Coleções em Kotlin", Nivel.INICIANTE)
    
    //Criando uma formação e colocando os conteudos nela
    val formacao = Formacao("Backend com Kotlin e Java", listOf(conteudo1, conteudo2))
    
    //Matriculando um usuario em uma formação
    formacao.matricular(usuario)
    
    //Matriculando varios usuarios
    formacao.matricular(usuario2, usuario3)
    
    println("Listando os conteudos em uma formação")
    for (conteudo in formacao) {
        println(conteudo.nome)
    }
    
    println()
    println("Lista de inscritos em uma formação:")
    formacao.getInscrito().forEach {                                     
        i -> println("- $i")
    }

}