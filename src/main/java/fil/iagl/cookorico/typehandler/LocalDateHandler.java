package fil.iagl.cookorico.typehandler;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.stereotype.Component;

@Component
@MappedTypes(LocalDate.class)
public class LocalDateHandler extends BaseTypeHandler<LocalDate> {

	@Override
	public void setNonNullParameter(final PreparedStatement ps, final int i, final LocalDate parameter,
			final JdbcType jdbcType) throws SQLException {
		if (parameter == null) {
			ps.setDate(i, null);
		} else {
			ps.setDate(i, Date.valueOf(parameter));
		}
	}

	@Override
	public LocalDate getNullableResult(final ResultSet rs, final String columnName) throws SQLException {
		final Date date = rs.getDate(columnName);
		if (date != null) {
			return date.toLocalDate();
		}
		return null;
	}

	@Override
	public LocalDate getNullableResult(final ResultSet rs, final int columnIndex) throws SQLException {
		final Date date = rs.getDate(columnIndex);
		if (date != null) {
			return date.toLocalDate();
		}
		return null;
	}

	@Override
	public LocalDate getNullableResult(final CallableStatement cs, final int columnIndex) throws SQLException {
		final Date date = cs.getDate(columnIndex);
		if (date != null) {
			return date.toLocalDate();
		}
		return null;
	}

}
