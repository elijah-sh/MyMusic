package com.music.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.dao.SongListMapper;
import com.music.pojo.ListCategory;
import com.music.pojo.SongList;
import com.music.pojo.User;
import com.music.service.ISongListService;

@Service
public class SongListServiceImpl implements ISongListService {
	 @Autowired
	 private SongListMapper songListMapper;
	
	 // 主页面榜单
		@Override
	 public List<SongList> getHotSongs(int limit) {
			// TODO Auto-generated method stub
			return songListMapper.getHotSongLists(limit);
			
			/*	List<Song> songs=service.getHotSongs(10);
			 * request.setAttribute("songs", songs);
			request.getRequestDispatcher("home/song/hotSongs.jsp").forward(request, response);*/
		}
		
	public List<SongList> getSongListsByCategoryId(int categoryId) {
	 
		return null;
	}

	@Override
	public SongList getSongListById(int songListId) {
		// TODO Auto-generated method stub
		return null ;
	}

	/* 
	 *   首页  热门歌单
	 */
	@Override
	public List<SongList> getHotSongLists(int limit) {
		// TODO Auto-generated method stub
		return songListMapper.getHotSongLists(limit);
	}

	@Override
	public List<SongList> getSongListByCategory(ListCategory listCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.music.service.ISongListService#createSongList(com.music.pojo.SongList)
	 */
	@Override
	public boolean createSongList(SongList songList) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.music.service.ISongListService#collectSongList(com.music.pojo.User, com.music.pojo.SongList)
	 */
	@Override
	public boolean collectSongList(User user, SongList songList) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.music.service.ISongListService#getCreateSongList(com.music.pojo.User)
	 */
	@Override
	public List<SongList> getCreateSongList(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.music.service.ISongListService#getCollectSongList(com.music.pojo.User)
	 */
	@Override
	public List<SongList> getCollectSongList(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.music.service.ISongListService#listAllSongList()
	 */
	@Override
	public List<SongList> listAllSongList() {
		// TODO Auto-generated method stub
		return null;
	}

	

	/*// 得到完整信息的歌单(建立与歌单关联的需要的映射)
	//歌单id,歌单创建者，歌单图片，歌单创建时间，歌单创建者的头像，歌单所属分类，歌单介绍，歌曲列表，歌曲评论
	public SongList getSongListById(int songListId) {
		//1.先获取歌单信息，以及创建歌单的用户
		SongListDao songListDao=new SongListDaoImpl();
		SongList songList=songListDao.findById(songListId);
		
		//根据用户id完善用户信息
		UserDao userDao=new UserDaoImpl();
		User creater=userDao.findById(songList.getCreater().getId());
		songList.setCreater(creater);
		
		//2.根据歌单id，获取所属分类
		QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
		String sql="select list_category.id,list_category.`name`,parent"+
				" from song_list join list_to_category on song_list.id=list_to_category.song_list_id "
				+" join list_category on list_to_category.list_category_id=list_category.id "
				+ " where song_list.id=?";
		Object param=songListId;
		List<ListCategory> categories=null;
		try {
			categories=runner.query(sql, param, new BeanListHandler<>(ListCategory.class));
			songList.setCategories(categories);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		//3.根据歌单id，获取歌单中的歌曲
		sql="select song.id as song_id,song.`name` as song_name,song.path as song_path,"
				+" album.id as album_id,album.name as album_name,singer.id as singer_id,singer.name as singer_name,album.img"
				+" from song join song_to_list on song.id=song_to_list.song_id"
				+" join song_list on song_list.id=song_to_list.song_list_id"
				+" join album on album.id=song.album_id"
				+" join singer on singer.id=album.singer_id"
				+" where song_list.id=?";
		param=songListId;
		try {
			List<Object[]> result=runner.query(sql, param, new ArrayListHandler());
			List<Song> songs=new ArrayList<>();
			for (Object[] objects : result) {
				Song song=new Song();
				song.setId((Integer)objects[0]);
				song.setName((String)objects[1]);
				song.setPath((String)objects[2]);
				Album album=new Album();
				album.setId((Integer)objects[3]);
				album.setName((String)objects[4]);
				album.setImg((String)objects[7]);
				Singer singer=new Singer();
				singer.setId((Integer)objects[5]);
				singer.setName((String)objects[6]);
				album.setSinger(singer);
				song.setAlbum(album);
				songs.add(song);
			}
			songList.setSongs(songs);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		//根据歌单id获取歌单评论
		sql="select list_comment.id as list_comment_id,list_comment.content,`user`.id,`user`.username,`user`.img"
			+" from song_list join list_comment on song_list.id=list_comment.song_list_id"
			+" join user on `user`.id=list_comment.user_id"
			+" where song_list.id=?";
		param=songListId;
		try {
			List<Object[]> result=runner.query(sql, param, new ArrayListHandler());
			List<ListComment> comments=new ArrayList<>();
			for (Object[] objects : result) {
				ListComment listComment=new ListComment();
				listComment.setId((Integer)objects[0]);
				listComment.setContent((String)objects[1]);
				User user=new User();
				user.setId((Integer)objects[2]);
				user.setUsername((String)objects[3]);
				user.setImg((String)objects[4]);
				listComment.setUser(user);
				comments.add(listComment);
			}
			songList.setComments(comments);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return songList;
		
	}

	// 根据热度取得歌单
	public List<SongList> getHotSongLists(int limit) {
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		//查询总歌曲播放数最多的前limit个歌单
		String sql = "select song_list.*, sum(song.count) sum_count"
				+" from song_list"
				+" join song_to_list on song_to_list.song_list_id = song_list.id"
				+" join song on song.id = song_to_list.song_id"
				+" group by song_list.id"
				+" order by sum_count desc"
				+" limit ?";
		Object para = limit;
		List<SongList> songList = null;
		try {
			songList = runner.query(sql, para, new BeanListHandler<>(
					SongList.class));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return songList;
	}
	
	// 根据歌单分类取得歌单
	public List<SongList> getSongListByCategory(ListCategory listCategory) {
		
		select list_category.`name` as list_category_name,list_category.id as list_category_id,song_list.id as song_list_id,song_list.`name` as song_list_name,`user`.username,song_list.img
		from list_category join list_to_category on list_category.id=list_to_category.list_category_id
		join song_list on song_list.id=list_to_category.song_list_id
		join user on `user`.id=song_list.user_id
		where list_category.id=2
		
		return null;
	}

	// 创建歌单,songList里面只需要有歌单名，创建者，创建时间
	public boolean createSongList(SongList songList) {
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "INSERT INTO `song_list` (`name`,  `create_time`, `user_id`) VALUES (?, ?, ?)";
		Object[] params = { songList.getName(), songList.getCreate_time(), songList.getCreater().getId() };
		int result = -1;
		try {
			result = runner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			result = -1;
		}
		return result > 0 ? true : false;
	}

	// 收藏歌单
	public boolean collectSongList(User user, SongList songList) {
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "INSERT INTO `list_collection` (`song_list_id`, `user_id`) VALUES (?, ?)";
		Object[] params = { songList.getId(), user.getId() };
		int result = -1;
		try {
			result = runner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			result = -1;
		}
		return result > 0 ? true : false;
	}

	// 获得用户创建的歌单
	public List<SongList> getCreateSongList(User user) {
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from song_list where user_id = ?";
		Object param = user.getId();
		List<SongList> songLists = null;
		try {
			songLists = runner
					.query(sql, param, new BeanListHandler<>(SongList.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return songLists;
	}

	// 获得用户收藏的歌单
	public List<SongList> getCollectSongList(User user) {
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select song_list.*"
				+" from list_collection"
				+" join song_list on song_list.id = list_collection.song_list_id"
				+" where list_collection.user_id = ?";
		Object param = user.getId();
		List<SongList> songLists = null;
		try {
			songLists = runner
					.query(sql, param, new BeanListHandler<>(SongList.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return songLists;
	}
	
	//得到全部歌单
	public List<SongList> listAllSongList() {
		return dao.listAll();
	}
	
*/
}
