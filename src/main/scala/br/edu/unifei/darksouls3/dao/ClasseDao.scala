package br.edu.unifei.darksouls3.dao

import br.edu.unifei.darksouls3.models.Classe

import scala.slick.driver.PostgresDriver.simple._

object ClasseDao {

  val classes = TableQuery[Classe]

  def listaClasse()={
    for {
      c <- classes
    } yield c
  }

  def buscaClasse(nome : String)= {
    for {
      a <- classes
      if a.nome === nome
    } yield a
  }



}
