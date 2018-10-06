//import br.edu.unifei.darksouls3._
import br.edu.unifei.darksouls3.models._

import scala.slick.driver.PostgresDriver.simple._
import scala.collection.mutable.ArrayBuffer

object CreateDb {
  def main(args: Array[String]): Unit = {

    val connectionUrl = "jdbc:postgresql://localhost/Teste?user=postgres&password=admin"

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
        val pactos = TableQuery[Pacto]


        ( classes.ddl ++ regioes.ddl ++ humanoides.ddl ++ aparencias.ddl ++ armas.ddl ++ armaduras.ddl ++ monstros.ddl ++ itens.ddl ++ pactos.ddl).create

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

        val aparenciaInput = io.Source.fromFile("aparencias.csv")
        for (line <- aparenciaInput.getLines) {
          val cols = line.split(";").map(_.trim)
          aparencias += (0,cols(0),cols(1),cols(2),cols(3),cols(4),cols(5).toFloat,cols(6))
        }
        aparenciaInput.close

        val pactoInput = io.Source.fromFile("pactos.csv")
        for (line <- pactoInput.getLines) {
          val cols = line.split(";")
          pactos += (cols(0),cols(1))
        }
        pactoInput.close

        val humanoideInput = io.Source.fromFile("humanoides.csv")

        for (line <- humanoideInput.getLines) {
          val cols = line.split(";")
          //println (cols(0))
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

           if(cols(4)== "NULL")
             itens += (cols(0),cols(1).toInt,cols(2),Some(cols(3)), None)
           else {

             itens += (cols(0),cols(1).toInt,cols(2),None, Some(cols(4)))
           }
        }
        itemInput.close


        /*armas += ("Espadão", 20, 200, 100, 300, false, Categoria.espada)
        monstros += ("Crystal Lizard", 100, 0, false, 30, 220, 200, 40, false, false, "LugarNenhum")
        armaduras += ("Xanthous Crown", 10, 100, 49, 58, false, Categoria.elmo)
        humanoides ++= Seq(
          ("Jolly", 1500, 60, 90, 345932, true, 40, 40, 12, 10, 150, 150, 90, 42, "Assassin",2,"LugarNenhum"),
          ("Jollie", 1100, 60, 90, 311822, true, 18, 16, 50, 20, 100, 190, 90, 42,"Mercenary",4,"LugarNenhum")
        )*/







        println("Creation completed.")
    }
  }
}
