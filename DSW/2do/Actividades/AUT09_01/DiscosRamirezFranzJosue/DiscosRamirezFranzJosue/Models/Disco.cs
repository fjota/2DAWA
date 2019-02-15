//------------------------------------------------------------------------------
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
  using System.Collections.Generic;
  using System.ComponentModel.DataAnnotations;

  public partial class Disco
  {
    [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
    public Disco()
    {
      this.DiscoTipoes = new HashSet<DiscoTipo>();
      this.Puntuacions = new HashSet<Puntuacion>();
    }
    
    public int IdDisco { get; set; }
    [Required]
    public string Titulo { get; set; }
    [Required]
    [Display(Name = "Año")]
    //[Range(1900, int.MaxValue, ErrorMessage = "Porfavor introduzca un año mayor a 1900")]
    [RangeAttribute(1900.0, double.MaxValue, ErrorMessage = "Porfavor introduzca un año mayor a 1900")]
    public Nullable<double> Agno { get; set; }
    [Required]
    [Display(Name = "Interprete")]
    public Nullable<int> IdInterprete { get; set; }
    [Required]
    [Display(Name = "Discografica")]
    public Nullable<int> IdDiscografica { get; set; }

    public virtual Interprete Interprete { get; set; }
    [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
    public virtual ICollection<DiscoTipo> DiscoTipoes { get; set; }
    [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
    public virtual ICollection<Puntuacion> Puntuacions { get; set; }
    public virtual Discografica Discografica { get; set; }
  }
}
