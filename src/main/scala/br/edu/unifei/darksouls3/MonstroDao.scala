package br.edu.unifei.darksouls3

import scala.slick.driver.PostgresDriver.simple._

object MonstroDao {

  val monstros = TableQuery[Monstro]

  def listaMonstro()={
    for {
      m <- monstros
    } yield m
  }

  def buscaMonstro(nome : String)= {
    for {
      m <- monstros
      if m.nome === nome
    } yield m
  }



}
