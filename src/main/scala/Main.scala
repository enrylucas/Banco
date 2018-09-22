import br.edu.unifei.darksouls3.Categoria.Value

import scala.slick.driver.PostgresDriver.simple._
import br.edu.unifei.darksouls3._

object Main {

  // this is a class that represents the table I've created in the database
  /*class Users(tag: Tag) extends Table[(Int, String)](tag, "users") {
    def id = column[Int]("id")
    def username = column[String]("username")
    def * = (id, username)
  }*/

  def main(args: Array[String]): Unit = {

    // my database server is located on the localhost
    // database name is "my-db"
    // username is "postgres"
    // and password is "postgres"
    val connectionUrl = "jdbc:postgresql://localhost/Teste?user=postgres&password=system"

    Database.forURL(connectionUrl, driver = "org.postgresql.Driver") withSession {
      implicit session =>

        val humanoides = TableQuery[Humanoide]
        val armas = TableQuery[Arma]
        val armaduras = TableQuery[Armadura]
        val regioes = TableQuery[Regiao]
        val aparencias = TableQuery[Aparencia]
        val classes = TableQuery[Classe]
        val monstros = TableQuery[Monstro]

        ( classes.ddl ++ regioes.ddl ++ humanoides.ddl ++ aparencias.ddl ++ armas.ddl ++ armaduras.ddl ++ monstros.ddl).create

        //Como criar linhas na tabela:
        classes += ("padre",10,2,3,5,10)
        aparencias += (10,"liso", "marrom","grande", "verde", "M", 2, "preto")
        regioes += ("LugarNenhum",2)
        armas += ("Espadão", 20, 200, 100, 300, false, Categoria.espada)
        monstros += ("Crystal Lizard", 100, 0, 0, 1000, false, 0, 0, 0, 0, 200, 40, false, false, "LugarNenhum")

        humanoides ++= Seq(
          ("Jolly", "padre", 1500, 60, 90, 345932, true, 40, 40, 12, 10, 150, 150, 90, 42,10,"LugarNenhum"),
          ("Jollie", "padre", 1100, 60, 90, 311822, true, 18, 16, 50, 20, 100, 190, 90, 42,10,"LugarNenhum")
        )

        //Como executar queries:
        /*humanoides foreach { case (nome, vida, foco, estamina, almas, hollow, forca, destreza, inteligencia, fe, defesaFisica, defesaMagica, nivel, cargaEquipamento) =>
          println(nome, vida, foco, estamina, almas, hollow, forca, destreza, inteligencia, fe, defesaFisica, defesaMagica, nivel, cargaEquipamento)
        }*/

        /*val users = TableQuery[Users]


        // SELECT * FROM users
        users.list foreach { row =>
          println("user with id " + row._1 + " has username " + row._2)
        }

        // SELECT * FROM users WHERE username='john'
        users.filter(_.username === "john").list foreach { row =>
          println("user whose username is 'john' has id "+row._1 )
        }*/









    }
  }
}