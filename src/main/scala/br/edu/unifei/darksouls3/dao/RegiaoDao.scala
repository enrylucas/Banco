package br.edu.unifei.darksouls3.dao

import br.edu.unifei.darksouls3.models.Regiao

import scala.slick.driver.PostgresDriver.simple._

object RegiaoDao {

  val regioes = TableQuery[Regiao]

  def listaRegiao()={
    for {
      r <- regioes
    } yield r
  }

  def buscaRegiao(nome : String)= {
    for {
      r <- regioes
      if r.nome === nome
    } yield r
  }



}
