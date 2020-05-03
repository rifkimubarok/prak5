using System;
using System.Collections.Generic;
using System.Collections.Concurrent;
using webApi.Model;

namespace webApi.Repositories
{
    public class NoteRepository : INoteRepository
    {
        public static readonly ConcurrentDictionary<string, Note> Notes = new ConcurrentDictionary<string, Note>();
        public NoteRepository()
        {
            Add(new Note { Title = "Hello", Content = "i'm Fine" });
        }

        public void Add(Note item)
        {
            item.Id = Guid.NewGuid();
            Notes[item.Id.ToString()] = item;
        }

        public IEnumerable<Note> GetAll()
        {
            return Notes.Values;
        }

        public Note GetNoteById(Guid id)
        {
            Note item;
            Notes.TryGetValue(id.ToString(), out item);
            return item;
        }

        public Note Remove(Guid id)
        {
            Note item;
            Notes.TryGetValue(id.ToString(), out item);
            Notes.TryRemove(id.ToString(), out item);
            return item;
        }

        public void Update(Note item)
        {
            Notes[item.Id.ToString()] = item;
        }
    }
}
