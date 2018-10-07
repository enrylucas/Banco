import scala.slick.driver.PostgresDriver.simple._
import br.edu.unifei.darksouls3._
import br.edu.unifei.darksouls3.dao.HumanoideDao
import br.edu.unifei.darksouls3.models._

import scala.concurrent._

object App {

  def main(args: Array[String]): Unit = {

    // my database server is located on the localhost
    // database name is "my-db"
    // username is "postgres"
    // and password is "postgres"
    val connectionUrl = "jdbc:postgresql://localhost/Teste?user=postgres&password=system"
    Database.forURL(connectionUrl, driver = "org.postgresql.Driver") withSession {
      implicit session =>

        /*val humanoides = TableQuery[Humanoide]
        val armas = TableQuery[Arma]
        val armaduras = TableQuery[Armadura]
        val regioes = TableQuery[Regiao]
        //val aparencias = TableQuery[Aparencia]
        val classes = TableQuery[Classe]
        val monstros = TableQuery[Monstro]*/


        //Como executar queries:
        /*humanoides foreach { case (nome, vida, foco, estamina, almas, hollow, forca, destreza, inteligencia, fe, defesaFisica, defesaMagica, nivel, cargaEquipamento, idAparencia, regiaoNome) =>
          println(nome, vida, foco, estamina, almas, hollow, forca, destreza, inteligencia, fe, defesaFisica, defesaMagica, nivel, cargaEquipamento, idAparencia, regiaoNome)
        }*/

        //Exemplo SELECT * WHERE regiaoNome = 'LugarNenhum'
       // humanoides.filter(_.regiaoNome === "Archdragon Peak").list foreach { row =>
       //   println(s"${row._1} | ${row._2} | ${row._3} | ${row._4} | ${row._5} | ${row._6} | ${row._7} | ${row._8} | ${row._9} | ${row._10} | ${row._11} | ${row._12} | ${row._13} | ${row._14} | ${row._15} | ${row._16} | ${row._17}")
       // }

        //Exemplo Inner Join
        /*val innerJoin = for {
          (h, r) <- humanoides join regioes on (_.regiaoNome === _.nome)
        } yield (r.nome, h.nome)
        innerJoin.sortBy(_._1).foreach{col => println(col)}*/

        /*val q1 = for {
          h <- humanoides
          if h.vida > 100
        }yield h.regiaoNome*/

        val q2 = HumanoideDao.listaInventario("Misty")

        q2.foreach(row => println(s"${row._1} : ${row._3}"))

       // AparenciaDao.listaAparencia().list.foreach{row => println(row)}

       // println(AparenciaDao.buscaAparencia(4).first)

    }
  }
}