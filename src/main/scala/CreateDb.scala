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
        val itens = TableQuery[Item]

        ( classes.ddl ++ regioes.ddl ++ humanoides.ddl ++ aparencias.ddl ++ armas.ddl ++ armaduras.ddl ++ monstros.ddl ++ itens.ddl).create

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

        val aparenciaInput = io.Source.fromFile("aparencias.csv")
        for (line <- aparenciaInput.getLines) {
          val cols = line.split(";").map(_.trim)
          aparencias += (0,cols(0),cols(1),cols(2),cols(3),cols(4),cols(5).toFloat,cols(6))
        }
        aparenciaInput.close

        val humanoideInput = io.Source.fromFile("humanoides.csv")

        for (line <- humanoideInput.getLines) {
          val cols = line.split(";").map(_.trim)
          val q1 = classes.filter(_.nome === cols(10)).first
          humanoides += (cols(0), cols(1).toInt ,cols(2).toInt,cols(3).toInt,cols(4).toLong,cols(5).toBoolean,q1._2,q1._3,q1._4,q1._5,cols(6).toInt, cols(7).toInt, cols(8).toInt,cols(9).toInt,cols(10),cols(11).toInt,cols(12))
        }
        humanoideInput.close

        val monstroInput = io.Source.fromFile("monstros.csv")
        for (line <- monstroInput.getLines) {
          val cols = line.split(";")
          monstros += (cols(0),cols(1).toInt,cols(2).toLong,cols(3).toBoolean,cols(4).toInt,cols(5).toInt,cols(6).toInt,cols(7).toInt,cols(8).toBoolean,cols(9).toBoolean, cols(10))
        }
        monstroInput.close

        val itemInput = io.Source.fromFile("itens.csv")
        for (line <- itemInput.getLines) {
          val cols = line.split(";")
          itens += (cols(0),cols(1).toInt,cols(2))
        }
        itemInput.close

        println("Creation completed.")
    }
  }
}
