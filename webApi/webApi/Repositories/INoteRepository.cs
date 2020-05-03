using System;
using System.Collections.Generic;
using webApi.Model;
namespace webApi.Repositories
{
    public interface INoteRepository
    {
        IEnumerable<Note> GetAll();
        Note GetNoteById(Guid id);
        void Add(Note item);
        void Update(Note item);
        Note Remove(Guid id);
    }
}
