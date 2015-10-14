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

/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Vladislav Zablotsky
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

@Component
@MappedTypes( LocalDate.class )
public class LocalDateHandler extends BaseTypeHandler< LocalDate > {

    @Override
    public void setNonNullParameter( final PreparedStatement ps , final int i , final LocalDate parameter , final JdbcType jdbcType ) throws SQLException {
        if ( parameter == null ) {
            ps.setDate( i, null );
        } else {
            ps.setDate( i, Date.valueOf( parameter ) );
        }
    }

    @Override
    public LocalDate getNullableResult( final ResultSet rs , final String columnName ) throws SQLException {
        final Date date = rs.getDate( columnName );
        if ( date != null ) {
            return date.toLocalDate();
        }
        return null;
    }

    @Override
    public LocalDate getNullableResult( final ResultSet rs , final int columnIndex ) throws SQLException {
        final Date date = rs.getDate( columnIndex );
        if ( date != null ) {
            return date.toLocalDate();
        }
        return null;
    }

    @Override
    public LocalDate getNullableResult( final CallableStatement cs , final int columnIndex ) throws SQLException {
        final Date date = cs.getDate( columnIndex );
        if ( date != null ) {
            return date.toLocalDate();
        }
        return null;
    }

}
