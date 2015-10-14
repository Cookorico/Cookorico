package fil.iagl.cookorico.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.stereotype.Component;

@Component
@MappedTypes( LocalDateTime.class )
public class LocalDateTimeHandler extends BaseTypeHandler< LocalDateTime > {

    @Override
    public void setNonNullParameter( final PreparedStatement ps , final int i , final LocalDateTime parameter , final JdbcType jdbcType ) throws SQLException {
        if ( parameter == null ) {
            ps.setTimestamp( i, null );
        } else {
            ps.setTimestamp( i, Timestamp.valueOf( parameter ) );
        }
    }

    @Override
    public LocalDateTime getNullableResult( final ResultSet rs , final String columnName ) throws SQLException {
        final Timestamp ts = rs.getTimestamp( columnName );
        if ( ts != null ) {
            return LocalDateTime.ofInstant( ts.toInstant(), ZoneId.systemDefault() );
        }
        return null;
    }

    @Override
    public LocalDateTime getNullableResult( final ResultSet rs , final int columnIndex ) throws SQLException {
        final Timestamp ts = rs.getTimestamp( columnIndex );
        if ( ts != null ) {
            return LocalDateTime.ofInstant( ts.toInstant(), ZoneId.systemDefault() );
        }
        return null;
    }

    @Override
    public LocalDateTime getNullableResult( final CallableStatement cs , final int columnIndex ) throws SQLException {
        final Timestamp ts = cs.getTimestamp( columnIndex );
        if ( ts != null ) {
            return LocalDateTime.ofInstant( ts.toInstant(), ZoneId.systemDefault() );
        }
        return null;
    }
}
