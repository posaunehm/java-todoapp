package jp.guildworks.service;

import jp.guildworks.entity.Todo;
import jp.guildworks.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public List<Todo> findAll() {
        return todoRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public void delete(Long id) {
        todoRepository.delete(id);
    }

    public Todo find(Long id) {
        return todoRepository.findOne(id);
    }
}
