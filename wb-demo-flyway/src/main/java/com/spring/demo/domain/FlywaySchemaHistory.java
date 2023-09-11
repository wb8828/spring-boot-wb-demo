package com.spring.demo.domain;

import com.spring.demo.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;


@EqualsAndHashCode(callSuper = true)
@Data
public class FlywaySchemaHistory extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long installedRank;

    /**
     * $column.columnComment
     */
    private String version;

    /**
     * $column.columnComment
     */
    private String description;

    /**
     * $column.columnComment
     */
    private String type;

    /**
     * $column.columnComment
     */
    private String script;

    /**
     * $column.columnComment
     */
    private Long checksum;

    /**
     * $column.columnComment
     */
    private String installedBy;

    /**
     * $column.columnComment
     */
    private Date installedOn;

    /**
     * $column.columnComment
     */
    private Long executionTime;

    /**
     * $column.columnComment
     */
    private Integer success;


}
