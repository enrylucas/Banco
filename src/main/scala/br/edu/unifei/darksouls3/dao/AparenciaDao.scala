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



}
