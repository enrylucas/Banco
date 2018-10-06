package br.edu.unifei.darksouls3

import scala.slick.driver.PostgresDriver.simple._

object ArmaDao {

  val armas = TableQuery[Arma]

  def listaArma()={
    for {
      a <- armas
    } yield a
  }

  def buscaArma(nome : String)= {
    for {
      a <- armas
      if a.nome === nome
    } yield a
  }



}
