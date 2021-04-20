package com.liuyk.asimple.enums;

import com.liuyk.asimple.util.DateUtil;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @author 三七
 */
public enum TimeQuantumEnum {

    /**
     * 今天：从00:00:00到今天23:59:59
     */
    TODAY("今天", 1) {
        @Override
        public Date getStartTime() {
            LocalDateTime localDateTime = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
            return DateUtil.localDateTime2Date(localDateTime);
        }

        @Override
        public Date getEndTime() {
            LocalDateTime localDateTime = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59);
            return DateUtil.localDateTime2Date(localDateTime);
        }
    },

    /**
     * 昨天：昨天00:00:00到昨天23:59:59
     */
    YESTERDAY("昨天", 2) {
        @Override
        public Date getStartTime() {
            LocalDateTime localDateTime = LocalDateTime.now().minusDays(1).withHour(0).withMinute(0).withSecond(0);
            return DateUtil.localDateTime2Date(localDateTime);
        }

        @Override
        public Date getEndTime() {
            LocalDateTime localDateTime = LocalDateTime.now().minusDays(1).withHour(23).withMinute(59).withSecond(59);
            return DateUtil.localDateTime2Date(localDateTime);
        }
    },

    /**
     * 近7天：包含今天的前7天00:00:00到今天23:59:59
     */
    LATEST_7_DAYS("近7天", 3) {
        @Override
        public Date getStartTime() {
            LocalDateTime localDateTime = LocalDateTime.now().minusDays(6).withHour(0).withMinute(0).withSecond(0);
            return DateUtil.localDateTime2Date(localDateTime);
        }

        @Override
        public Date getEndTime() {
            LocalDateTime localDateTime = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59);
            return DateUtil.localDateTime2Date(localDateTime);
        }
    },

    LATEST_7_DAYS_NO_TODAY("近7天(不包含今日)", 1003) {
        @Override
        public Date getStartTime() {
            LocalDateTime localDateTime = LocalDateTime.now().minusDays(7).withHour(0).withMinute(0).withSecond(0);
            return DateUtil.localDateTime2Date(localDateTime);
        }

        @Override
        public Date getEndTime() {
            LocalDateTime localDateTime = LocalDateTime.now().minusDays(1).withHour(23).withMinute(59).withSecond(59);
            return DateUtil.localDateTime2Date(localDateTime);
        }
    },

    /**
     * 近30天：包含今天的前30天00:00:00到今天23:59:59
     */
    LATEST_30_DAYS("近30天", 4) {
        @Override
        public Date getStartTime() {
            LocalDateTime localDateTime = LocalDateTime.now().minusDays(29).withHour(0).withMinute(0).withSecond(0);
            return DateUtil.localDateTime2Date(localDateTime);
        }

        @Override
        public Date getEndTime() {
            LocalDateTime localDateTime = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59);
            return DateUtil.localDateTime2Date(localDateTime);
        }

    },
    LATEST_30_DAYS_NO_TODAY("近30天(不包含今日)", 1004) {
        @Override
        public Date getStartTime() {
            LocalDateTime localDateTime = LocalDateTime.now().minusDays(31).withHour(0).withMinute(0).withSecond(0);
            return DateUtil.localDateTime2Date(localDateTime);
        }

        @Override
        public Date getEndTime() {
            LocalDateTime localDateTime = LocalDateTime.now().minusDays(1).withHour(23).withMinute(59).withSecond(59);
            return DateUtil.localDateTime2Date(localDateTime);
        }

    },

    /**
     * 上周：从上周一00:00:00到上周日23:59:59
     */
    LAST_WEEK("上周", 5) {
        @Override
        public Date getStartTime() {
            LocalDateTime localDateTime = LocalDateTime.now().minusWeeks(1).with(DayOfWeek.MONDAY).withHour(0).withMinute(0).withSecond(0);
            return DateUtil.localDateTime2Date(localDateTime);
        }

        @Override
        public Date getEndTime() {
            LocalDateTime localDateTime = LocalDateTime.now().minusWeeks(1).with(DayOfWeek.SUNDAY).withHour(23).withMinute(59).withSecond(59);
            return DateUtil.localDateTime2Date(localDateTime);
        }
    },

    THIS_WEEK("本周", 6) {
        @Override
        public Date getStartTime() {
            LocalDateTime localDateTime = LocalDateTime.now().with(DayOfWeek.MONDAY).withHour(0).withMinute(0).withSecond(0);
            return DateUtil.localDateTime2Date(localDateTime);
        }


        @Override
        public Date getEndTime() {
            LocalDateTime localDateTime = LocalDateTime.now().with(DayOfWeek.SUNDAY).withHour(23).withMinute(59).withSecond(59);
            return DateUtil.localDateTime2Date(localDateTime);
        }
    },

    /**
     * 上月：上月1号00:00:00到上月最后一天23:59:59
     */
    LAST_MONTH("上月", 7) {
        @Override
        public Date getStartTime() {
            LocalDateTime localDateTime = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()).minusMonths(1).withHour(0).withMinute(0).withSecond(0);
            return DateUtil.localDateTime2Date(localDateTime);
        }

        @Override
        public Date getEndTime() {
            LocalDateTime localDateTime = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()).minusDays(1).withHour(23).withMinute(59).withSecond(59);
            return DateUtil.localDateTime2Date(localDateTime);
        }
    },

    /**
     * 本月：本月1号00:00:00到本月最后一天23:59:59
     */
    THIS_MONTH("本月", 8) {
        @Override
        public Date getStartTime() {
            LocalDateTime localDateTime = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0);
            return DateUtil.localDateTime2Date(localDateTime);
        }

        @Override
        public Date getEndTime() {
            LocalDateTime localDateTime = LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth()).withHour(23).withMinute(59).withSecond(59);
            return DateUtil.localDateTime2Date(localDateTime);
        }

    },

    THIS_MONTH_NO_TODAY("本月(不含今日)", 1008) {
        @Override
        public Date getStartTime() {
            LocalDateTime localDateTime = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0);
            return DateUtil.localDateTime2Date(localDateTime);
        }

        @Override
        public Date getEndTime() {
            LocalDateTime localDateTime = LocalDateTime.now().minusDays(1).withHour(23).withMinute(59).withSecond(59);
            return DateUtil.localDateTime2Date(localDateTime);
        }
    },

    /**
     * 本年：今年1月1号00:00:00到现在
     */
    THIS_YEAR("今年", 9) {
        @Override
        public Date getStartTime() {
            LocalDateTime localDateTime = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()).withMonth(1).withHour(0).withMinute(0).withSecond(0);
            return DateUtil.localDateTime2Date(localDateTime);
        }

        @Override
        public Date getEndTime() {
            LocalDateTime localDateTime = LocalDateTime.now().withMonth(12).withDayOfMonth(31).withHour(23).withMinute(59).withSecond(59);
            return DateUtil.localDateTime2Date(localDateTime);
        }
    },

    /**
     * 去年：去年1月1号00:00:00到去年12月31号23:59:59
     */
    LAST_YEAR("去年", 10) {
        @Override
        public Date getStartTime() {
            LocalDateTime localDateTime = LocalDateTime.now().with(TemporalAdjusters.firstDayOfYear()).minusYears(1).withHour(0).withMinute(0).withSecond(0);
            return DateUtil.localDateTime2Date(localDateTime);
        }

        @Override
        public Date getEndTime() {
            LocalDateTime localDateTime = LocalDateTime.now().minusYears(1).withMonth(12).withDayOfMonth(31).withHour(23).withMinute(59).withSecond(59);
            return DateUtil.localDateTime2Date(localDateTime);
        }
    },

    /**
     * 近一年：从现在往前推365天
     */
    LAST_365_DAYS("近一年", 11) {
        @Override
        public Date getStartTime() {
            LocalDateTime localDateTime = LocalDateTime.now().minusDays(365).withHour(0).withMinute(0).withSecond(0);
            return DateUtil.localDateTime2Date(localDateTime);
        }

        @Override
        public Date getEndTime() {
            LocalDateTime localDateTime = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59);
            return DateUtil.localDateTime2Date(localDateTime);
        }
    },

    LAST_365_DAYS_NO_TODAY("近一年(不包含今日)", 1011) {
        @Override
        public Date getStartTime() {
            LocalDateTime localDateTime = LocalDateTime.now().minusDays(366).withHour(0).withMinute(0).withSecond(0);
            return DateUtil.localDateTime2Date(localDateTime);
        }

        @Override
        public Date getEndTime() {
            LocalDateTime localDateTime = LocalDateTime.now().minusDays(1).withHour(23).withMinute(59).withSecond(59);
            return DateUtil.localDateTime2Date(localDateTime);
        }
    },

    /**
     * 近90天：从现在往前推90天
     */
    LATEST_90_DAYS(",", 12) {
        @Override
        public Date getStartTime() {
            LocalDateTime localDateTime = LocalDateTime.now().minusDays(90).withHour(0).withMinute(0).withSecond(0);
            return DateUtil.localDateTime2Date(localDateTime);
        }

        @Override
        public Date getEndTime() {
            LocalDateTime localDateTime = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59);
            return DateUtil.localDateTime2Date(localDateTime);
        }
    },

    /**
     * 近半年：从现在往前推180天
     */
    LATEST_HALF_YEAR(",", 13) {
        @Override
        public Date getStartTime() {
            LocalDateTime localDateTime = LocalDateTime.now().minusDays(180).withHour(0).withMinute(0).withSecond(0);
            return DateUtil.localDateTime2Date(localDateTime);
        }

        @Override
        public Date getEndTime() {
            LocalDateTime localDateTime = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59);
            return DateUtil.localDateTime2Date(localDateTime);
        }
    };

    private final String dateName;
    private final int dateType;

    TimeQuantumEnum(String dateName, int dateType) {
        this.dateName = dateName;
        this.dateType = dateType;
    }

    public int getDateType() {
        return dateType;
    }

    public String getDateName() {
        return dateName;
    }

    public Date getStartTime() {
        return new Date();
    }

    public Date getEndTime() {
        return new Date();
    }

    public static TimeQuantumEnum findByDateType(int dateType) {
        for (TimeQuantumEnum e : TimeQuantumEnum.values()) {
            if (e.dateType == dateType) {
                return e;
            }
        }
        return null;
    }


}
