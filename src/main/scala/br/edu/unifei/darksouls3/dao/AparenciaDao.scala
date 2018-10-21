package br.edu.unifei.darksouls3.dao

import br.edu.unifei.darksouls3.models.Aparencia
import scala.slick.driver.PostgresDriver.simple._

object AparenciaDao {

  val aparencias = TableQuery[Aparencia]

  def listaAparencia()={
    for {
      a <- aparencias
    } yield a
  }

  def buscaAparencia(id : Int)= {
    for {
      a <- aparencias
      if a.idVisual === id
    } yield a
  }

  def criaAparencia(row: (String,String,String,String,String,Float,String))(implicit s: Session) = {
    aparencias += (0,row._1,row._2,row._3,row._4,row._5,row._6,row._7)
  }

  def deletaAparencia(id: Int)(implicit s: Session) = {
    aparencias.filter(_.idVisual === id).delete
  }

}
