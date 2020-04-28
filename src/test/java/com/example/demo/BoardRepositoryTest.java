// package com.example.demo;

// import java.util.List;
// import java.util.Optional;

// // import javax.transaction.Transactional;

// import com.example.demo.entity.Board;
// import com.example.demo.repository.BoardRepository;


// import org.junit.jupiter.api.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
// import org.springframework.test.annotation.Rollback;
// import org.springframework.test.context.junit4.SpringRunner;

// @RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment = WebEnvironment.MOCK)
// @AutoConfigureMockMvc
// // @Transactional
// public class BoardRepositoryTest {

//     @Autowired
//     private BoardRepository boardRepository;

//     @Test
//     @Rollback(false)
//     public void create() {
//         for(int i =0; i<100; i++){
//             Board board = new Board();
//             board.setTitle("tie"+i);
//             board.setContent("cot"+i);
//             board.setWriter("wrr"+i);
//             board.setPassword("pasord"+i);

//             Board newBoard = boardRepository.save(board);
//             System.out.println(newBoard);
//         }
//     }

//     @Test
//     public void list() {
//         //오름차순
//         List<Board> list = boardRepository.findAllByOrderByIdAsc();
//         for (int i = 0; i < list.size(); i++) {
//             System.err.println(list.get(i).getId());
//         }
//     }

    
//     @Test
//     public void list2() {
//         //내림차순
//         List<Board> list = boardRepository.findAllByOrderByIdDesc();
//         for (int i = 0; i < list.size(); i++) {
//             System.err.println(list.get(i).getId());
//         }
//     }



//     @Test
//     public void select() {
//         //boardRepository.flush();
//         Optional<Board> board = boardRepository.findById((long) 2106);
//         System.out.println(board.get().getTitle());
//     }


//     ////댓글찾기
//     @Test
//     public void select_댓글() {
//         //boardRepository.flush();
//         Optional<Board> boardopt = boardRepository.findById((long) 2116);
//         Board board =  boardopt.get();
//         int size = board.getComments().size();
//         System.out.println("dddddddddddddd"+size);
//     }


//     @Test
//     public void select_error() {
//         boardRepository.flush();
//         Optional<Board> board = boardRepository.findById((long) 2);
//         System.out.println(board.get().getTitle());
//     }


//     @Test
//     public void delete(){
//         Optional<Board> board = boardRepository.findById((long) 100);
//         boardRepository.delete(board.get());
//     }


//     @Test
//     public void findBytitle(){
//         List<Board> list = boardRepository.findByTitle("title3");
//         for (int i = 0; i < list.size(); i++) {
//             System.err.println(list.get(i).getId());
//         }
//     }


//     @Test
//     public void update(){
//         Optional<Board> optional = boardRepository.findById((long)2105);
//         Board board = optional.get();
//         // Board newBoard = new Board();
//         board.setTitle("new");
//         board.setPassword("new");
//         board.setWriter("new");
//         board.setContent("new");

//         // board.setBoard(newBoard);
//         boardRepository.save(board);
//     }


//     // @Test
//     // public void like(){
//     //     List<Board> boards = boardRepository.findByTitleLike("%title%");
//     //     System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@"+ boards.size() );
//     // }

//     // @Test
//     // public void like2(){
//     //     List<Board> boards = boardRepository.findByTitleLike("%date%");
//     //     System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@"+ boards.get(0).getTitle());
//     // }

//     // @Test
//     // public void like3(){
//     //     List<Board> boards = boardRepository.findByContentLike("%te%");
//     //     System.out.println("@@@@@@@@@@@@@@@@@@@@"+boards.size());
//     //     System.out.println("@@@@@@@@@@@@@@@@@@@@"+boards.get(0).getContent());
//     // }

    
// }