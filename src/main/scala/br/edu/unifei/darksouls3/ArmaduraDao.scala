package br.edu.unifei.darksouls3

import scala.slick.driver.PostgresDriver.simple._

object ArmaduraDao {

  val armaduras = TableQuery[Armadura]

  def listaArmadura()={
    for {
      a <- armaduras
    } yield a
  }

  def buscaArmadura(nome : String)= {
    for {
      a <- armaduras
      if a.nome === nome
    } yield a
  }



}
