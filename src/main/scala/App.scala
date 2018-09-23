import scala.slick.driver.PostgresDriver.simple._
import br.edu.unifei.darksouls3._
import scala.concurrent._

object App {

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


        //Como executar queries:
        /*humanoides foreach { case (nome, vida, foco, estamina, almas, hollow, forca, destreza, inteligencia, fe, defesaFisica, defesaMagica, nivel, cargaEquipamento, idAparencia, regiaoNome) =>
          println(nome, vida, foco, estamina, almas, hollow, forca, destreza, inteligencia, fe, defesaFisica, defesaMagica, nivel, cargaEquipamento, idAparencia, regiaoNome)
        }*/

        //Exemplo SELECT * WHERE regiaoNome = 'LugarNenhum'
        humanoides.filter(_.regiaoNome === "LugarNenhum").list foreach { row =>
          println(s"${row._1} | ${row._2} | ${row._3} | ${row._4} | ${row._5} | ${row._6} | ${row._7} | ${row._8} | ${row._9} | ${row._10} | ${row._11} | ${row._12} | ${row._13} | ${row._14} | ${row._15} | ${row._16} | ${row._17}")
        }

        //Exemplo Inner Join
        val innerJoin = for {
          (h, m) <- humanoides join monstros on (_.regiaoNome === _.regiaoNome)
        } yield (h.nome, m.nome)
        println(innerJoin.list)


    }
  }
}