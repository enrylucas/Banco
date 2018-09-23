import br.edu.unifei.darksouls3._
import scala.slick.driver.PostgresDriver.simple._

object CreateDb {
  def main(args: Array[String]): Unit = {

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
        armaduras += ("Xanthous Crown", 10, 100, 49, 58, false, Categoria.elmo)
        humanoides ++= Seq(
          ("Jolly", "padre", 1500, 60, 90, 345932, true, 40, 40, 12, 10, 150, 150, 90, 42,10,"LugarNenhum"),
          ("Jollie", "padre", 1100, 60, 90, 311822, true, 18, 16, 50, 20, 100, 190, 90, 42,10,"LugarNenhum")
        )

        println("Creation completed.")
    }
  }
}
