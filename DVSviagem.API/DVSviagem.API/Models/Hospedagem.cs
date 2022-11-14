
    
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace DVSviagem.API.Models
{
    [Table("Hospedagem")]
    public class Hospedagem
    {
        public int HospedagemId { get; set; }
        [Display(Name = "Nome_Hospedagem")]
        [Required(ErrorMessage = "Informe o nome da hospedagem")]
        [StringLength(100)]
        public string NomeHospedagem { get; set; }

        [Display(Name = "Telefone_Hospedagem")]
        [Required(ErrorMessage = "Informe o telefone da hospedagem")]
        [StringLength(15)]
        public string TelefoneHospedagem { get; set; }

        [Display(Name = "Email")]
        [Required(ErrorMessage = "Informe o email de contato da hospedagem")]
        [StringLength(80)]
        public string Email { get; set; }


        [Display(Name = "Logradouro")]
        [Required]
        [StringLength(100)]
        public string Logradouro { get; set; }

        [Display(Name = "Cidade")]
        [Required]
        [StringLength(90)]
        public string Cidade { get; set; }

        [Display(Name = "Estado_Hospedagem")]
        [Required(ErrorMessage = "Informe o estado onde estar localizada a hospedagem")]
        [StringLength(10)]
        public string Estado_Hospedagem { get; set; }

        [Display(Name = "Pais")]
        [Required(ErrorMessage = "Informe o pais onde estar localizada a hospedagem")]
        [StringLength(15)]
        public string Pais { get; set; }

        [Display(Name = "Valor_Diaria")]
        [Required(ErrorMessage = "Informe o valor da diária")]
        [StringLength(10)]
        public double ValorDiaria { get; set; }
    }
}
