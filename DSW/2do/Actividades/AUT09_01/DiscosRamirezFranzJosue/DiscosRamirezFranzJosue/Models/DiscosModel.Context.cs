﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Este código se generó a partir de una plantilla.
//
//     Los cambios manuales en este archivo pueden causar un comportamiento inesperado de la aplicación.
//     Los cambios manuales en este archivo se sobrescribirán si se regenera el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace DiscosRamirezFranzJosue.Models
{
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Infrastructure;
    
    public partial class DiscosEntities : DbContext
    {
        public DiscosEntities()
            : base("name=DiscosEntities")
        {
        }
    
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            throw new UnintentionalCodeFirstException();
        }
    
        public virtual DbSet<Cliente> Clientes { get; set; }
        public virtual DbSet<Disco> Discoes { get; set; }
        public virtual DbSet<DiscoTipo> DiscoTipoes { get; set; }
        public virtual DbSet<Interprete> Interpretes { get; set; }
        public virtual DbSet<Puntuacion> Puntuacions { get; set; }
        public virtual DbSet<Tipo> Tipoes { get; set; }
        public virtual DbSet<Grupos> Grupos { get; set; }
        public virtual DbSet<Usuario> Usuarios { get; set; }
        public virtual DbSet<UsuariosGrupos> UsuariosGrupos { get; set; }
    }
}
