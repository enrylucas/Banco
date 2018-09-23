import br.edu.unifei.darksouls3._
import scala.slick.driver.PostgresDriver.simple._
import scala.collection.mutable.ArrayBuffer

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
        val regiaoInput = io.Source.fromFile("regioes.csv")
        for (line <- regiaoInput.getLines) {
          val cols = line.split(";")
          regioes += (cols(0),cols(1).toInt)
        }
        regiaoInput.close

        val classeInput = io.Source.fromFile("classes.csv")
        for (line <- classeInput.getLines) {
          val cols = line.split(";").map(_.trim)
          classes += (cols(0),cols(1).toInt,cols(2).toInt,cols(3).toInt,cols(4).toInt,cols(5).toInt)
        }
        classeInput.close

        aparencias += (10,"liso", "marrom","grande", "verde", "M", 2, "preto")
        armas += ("Espadão", 20, 200, 100, 300, false, Categoria.espada)
        monstros += ("Crystal Lizard", 100, 0, 0, 1000, false, 0, 0, 0, 0, 200, 40, false, false, "LugarNenhum")
        armaduras += ("Xanthous Crown", 10, 100, 49, 58, false, Categoria.elmo)
        humanoides ++= Seq(
          ("Jolly", "Assassin", 1500, 60, 90, 345932, true, 40, 40, 12, 10, 150, 150, 90, 42,10,"LugarNenhum"),
          ("Jollie", "Mercenary", 1100, 60, 90, 311822, true, 18, 16, 50, 20, 100, 190, 90, 42,10,"LugarNenhum")
        )

        println("Creation completed.")
    }
  }
}