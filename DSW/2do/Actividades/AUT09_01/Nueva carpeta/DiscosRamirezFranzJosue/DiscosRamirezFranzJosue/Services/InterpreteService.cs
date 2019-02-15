using DiscosRamirezFranzJosue.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace DiscosRamirezFranzJosue.Services
{
  public class InterpreteService : IInterpreteService
  {
    private DiscosEntities discosEntities;

    public InterpreteService()
    {
      discosEntities = new DiscosEntities();
    }

    public bool CreateInterprete(Interprete interprete)
    {
      try
      {
        discosEntities.Interpretes.Add(interprete);
        discosEntities.SaveChanges();
        return true;
      }
      catch (Exception)
      {
        return false;
      }
    }

    public bool DeleteInterpreteById(int id)
    {
      try
      {
        Interprete interprete = SearchInterpreteById(id);
        discosEntities.Interpretes.Attach(interprete);
        discosEntities.Interpretes.Remove(interprete);
        discosEntities.SaveChanges();
        return true;
      }
      catch (Exception)
      {
        return false;
      }
    }

    public IEnumerable<Interprete> ListInterpretes()
    {
      return discosEntities.Interpretes;
    }

    public IEnumerable<Interprete> ListInterpretesByIdTipoDisco(int idTipo)
    {
      IEnumerable<Interprete> listInterpretes = (from interprete in ListInterpretes()
                                                join discos in discosEntities.Discoes on interprete.IdInterprete equals discos.IdInterprete
                                                join tipoDisco in discosEntities.DiscoTipoes on discos.IdDisco equals tipoDisco.IdDisco
                                                join tipo in discosEntities.Tipoes on tipoDisco.IdTipo equals tipo.IdTipo
                                                where tipoDisco.IdTipo == idTipo
                                                select interprete).Distinct();      
      return listInterpretes;
    }

    public Interprete SearchInterpreteById(int id)
    {
      return discosEntities.Interpretes.Where(item => item.IdInterprete == id).FirstOrDefault();
    }

    public bool UpdateInterprete(Interprete interprete)
    {

      try
      {
        discosEntities.Entry(interprete).State = System.Data.Entity.EntityState.Modified;       
        discosEntities.SaveChanges();
        return true;
      }
      catch (Exception)
      {
        return false;
      }

    }
  }
}