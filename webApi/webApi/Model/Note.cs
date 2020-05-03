using System;
using System.ComponentModel.DataAnnotations;
namespace webApi.Model
{
    public class Note
    {
        public Note()
        {
           

        }

        public Guid Id { get; set; }

        [Required]
        public string Title { get; set; }

        [Required]
        public string Content { get; set; }
    }
}
