package org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.model.Selection;
import org.utils.DbUtils;


public class SelectionDao {

	public List<Selection> getSelectionsByUserId(int courseId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Selection> selections = new ArrayList<Selection>();
		try {
			conn = DbUtils.getConnection();
			String sql = "select * from selection where selection_user=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, courseId);
			rs = ps.executeQuery();
			while (rs.next()) {
				selections.add(makeOneSelection(rs));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			DbUtils.releaseConnection(rs, ps, conn);
		}
		return selections;
	}
	public List<Selection> getSelectionsByCourseId(int courseId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Selection> selections = new ArrayList<Selection>();
		try {
			conn = DbUtils.getConnection();
			String sql = "select * from selection where selection_course=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, courseId);
			rs = ps.executeQuery();
			while (rs.next()) {
				selections.add(makeOneSelection(rs));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			DbUtils.releaseConnection(rs, ps, conn);
		}
		return selections;
	}

	public int add(Selection selection) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DbUtils.getConnection();
			String sql = "insert into selection(selection_user,selection_course)values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, selection.getSelectionUser());
			ps.setInt(2, selection.getSelectionCourse());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return 0;
		} finally {
			DbUtils.releaseConnection(null, ps, conn);
		}
	}


	public int deleteById(int selectionId) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DbUtils.getConnection();
			String sql = "delete from selection where selection_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, selectionId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return 0;
		} finally {
			DbUtils.releaseConnection(null, ps, conn);
		}
	}


	public List<Selection> getSelections() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Selection> selections = new ArrayList<Selection>();
		try {
			conn = DbUtils.getConnection();
			String sql = "select * from selection";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				selections.add(makeOneSelection(rs));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			DbUtils.releaseConnection(rs, ps, conn);
		}
		return selections;
	}

	public Selection makeOneSelection(ResultSet rs) throws SQLException {
		Selection selection = new Selection();
		selection.setSelectionId(rs.getInt("selection_id"));
		selection.setSelectionUser(rs.getInt("selection_user"));
		selection.setSelectionCourse(rs.getInt("selection_course"));
		return selection;
	}

	public int update(Selection selection) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DbUtils.getConnection();
			String sql = "update selection set selection_user=?,selection_course=? where selection_id=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, selection.getSelectionUser());
			ps.setInt(2, selection.getSelectionCourse());
			ps.setInt(3, selection.getSelectionId());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return 0;
		} finally {
			DbUtils.releaseConnection(rs, ps, conn);
		}
	}
}