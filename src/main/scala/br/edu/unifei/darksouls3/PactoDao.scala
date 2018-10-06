package br.edu.unifei.darksouls3

import scala.slick.driver.PostgresDriver.simple._

object PactoDao {

  val pactos = TableQuery[Pacto]

  def listaPacto()={
    for {
      p <- pactos
    } yield p
  }

  def buscaPacto(nome : String)= {
    for {
      p <- pactos
      if p.nome === nome
    } yield p
  }


}
