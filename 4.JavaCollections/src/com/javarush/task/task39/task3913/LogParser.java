package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private Path logDir;
    private List<String> allLogsLines;

    public LogParser(Path path) {
        this.logDir = path;
        allLogsLines = saveAllLogsLines();
    }

    private List<String> saveAllLogsLines() {
        final String[] files = logDir.toFile().list((dir, name) -> name.endsWith(".log"));
        final ArrayList<String> list = new ArrayList<>();
        for (String file : files) {
            try {
                list.addAll(Files.readAllLines(Paths.get(logDir + File.separator + file)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private Date getDate(String sDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date date = null;
        try {
            date = sdf.parse(sDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    private List<String[]> getSplitStringsByDate(Date after, Date before) {
        List<String[]> list = new ArrayList<>();
        Date logDate;
        for (String line : allLogsLines) {
            final String[] obj = line.split("\\t");
            logDate = getDate(obj[2]);
            if (after != null && before == null && logDate.getTime() >= after.getTime()) {
                list.add(obj);
            } else if (before != null && after == null && logDate.getTime() <= before.getTime()) {
                list.add(obj);
            } else if (before != null && after != null && logDate.getTime() >= after.getTime() && logDate.getTime() <= before.getTime()) {
                list.add(obj);
            } else if (after == null && before == null) {
                list.add(obj);
            }
        }
        return list;
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return getSplitStringsByDate(after, before)
                .stream()
                .map(strings -> strings[0])
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return getSplitStringsByDate(after, before).stream()
                .filter(strings -> strings[1].equals(user))
                .map(strings -> strings[0])
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return getSplitStringsByDate(after, before)
                .stream()
                .filter(strings -> strings[3].contains(event.toString()))
                .map(strings -> strings[0])
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return getSplitStringsByDate(after, before)
                .stream()
                .filter(strings -> strings[4].equals(status.toString()))
                .map(strings -> strings[0])
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getAllUsers() {
        return allLogsLines.stream()
                .map(s -> s.split("\\t")[1])
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return (int) getSplitStringsByDate(after, before)
                .stream()
                .map(s -> s[1])
                .distinct()
                .count();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        return (int) getSplitStringsByDate(after, before)
                .stream()
                .filter(s -> s[1].equals(user))
                .map(s -> s[3].split(" ")[0])
                .distinct()
                .count();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return getSplitStringsByDate(after, before)
                .stream()
                .filter(s -> s[0].equals(ip))
                .map(s -> s[1])
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return getSplitStringsByDate(after, before)
                .stream()
                .filter(s -> s[3].equals(Event.LOGIN.toString()))
                .map(s -> s[1])
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return getSplitStringsByDate(after, before)
                .stream()
                .filter(s -> s[3].equals(Event.DOWNLOAD_PLUGIN.toString()))
                .map(s -> s[1])
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return getSplitStringsByDate(after, before)
                .stream()
                .filter(s -> s[3].equals(Event.WRITE_MESSAGE.toString()))
                .map(s -> s[1])
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return getSplitStringsByDate(after, before)
                .stream()
                .filter(s -> s[3].contains(Event.SOLVE_TASK.toString()))
                .map(s -> s[1])
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return getSplitStringsByDate(after, before)
                .stream()
                .filter(s -> s[3].split(" ")[0].equals(Event.SOLVE_TASK.toString())
                        && Integer.parseInt(s[3].split(" ")[1]) == task)
                .map(s -> s[1])
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return getSplitStringsByDate(after, before)
                .stream()
                .filter(s -> s[3].contains(Event.DONE_TASK.toString()))
                .map(s -> s[1])
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return getSplitStringsByDate(after, before)
                .stream()
                .filter(s -> s[3].split(" ")[0].equals(Event.DONE_TASK.toString())
                        && Integer.parseInt(s[3].split(" ")[1]) == task)
                .map(s -> s[1])
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return getSplitStringsByDate(after, before)
                .stream()
                .filter(s -> s[1].equals(user) && s[3].split(" ")[0].equals(event.toString()))
                .map(s -> getDate(s[2]))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return getSplitStringsByDate(after, before)
                .stream()
                .filter(s -> s[4].equals(Status.FAILED.toString()))
                .map(s -> getDate(s[2]))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return getSplitStringsByDate(after, before)
                .stream()
                .filter(s -> s[4].equals(Status.ERROR.toString()))
                .map(s -> getDate(s[2]))
                .collect(Collectors.toSet());
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        boolean dateChanged = false;
        Date date = new Date(Long.MAX_VALUE);
        for (String[] s : getSplitStringsByDate(after, before)) {
            if (s[1].equals(user) && s[3].contains(Event.LOGIN.toString())) {
                Date sDate = getDate(s[2]);
                if (sDate.getTime() < date.getTime()) {
                    dateChanged = true;
                    date = sDate;
                }
            }
        }
        return dateChanged ? date : null;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        boolean dateChanged = false;
        Date date = new Date(Long.MAX_VALUE);
        for (String[] s : getSplitStringsByDate(after, before)) {
            if (s[1].equals(user)
                    && s[3].split(" ")[0].equals(Event.SOLVE_TASK.toString())
                    && Integer.parseInt(s[3].split(" ")[1]) == task) {
                Date sDate = getDate(s[2]);
                if (sDate.getTime() < date.getTime()) {
                    dateChanged = true;
                    date = sDate;
                }
            }
        }
        return dateChanged ? date : null;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        boolean dateChanged = false;
        Date date = new Date(Long.MAX_VALUE);
        for (String[] s : getSplitStringsByDate(after, before)) {
            if (s[1].equals(user)
                    && s[3].split(" ")[0].equals(Event.DONE_TASK.toString())
                    && Integer.parseInt(s[3].split(" ")[1]) == task) {
                Date sDate = getDate(s[2]);
                if (sDate.getTime() < date.getTime()) {
                    dateChanged = true;
                    date = sDate;
                }
            }
        }
        return dateChanged ? date : null;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return getSplitStringsByDate(after, before)
                .stream()
                .filter(s -> s[1].equals(user) && s[3].equals(Event.WRITE_MESSAGE.toString()))
                .map(s -> getDate(s[2]))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return getSplitStringsByDate(after, before)
                .stream()
                .filter(s -> s[1].equals(user) && s[3].equals(Event.DOWNLOAD_PLUGIN.toString()))
                .map(s -> getDate(s[2]))
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return getSplitStringsByDate(after, before)
                .stream()
                .map(s -> Event.valueOf(s[3].split(" ")[0]))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return getSplitStringsByDate(after, before)
                .stream()
                .filter(s -> s[0].equals(ip))
                .map(s -> Event.valueOf(s[3].split(" ")[0]))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return getSplitStringsByDate(after, before)
                .stream()
                .filter(s -> s[1].equals(user))
                .map(s -> Event.valueOf(s[3].split(" ")[0]))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return getSplitStringsByDate(after, before)
                .stream()
                .filter(s -> s[4].equals(Status.FAILED.toString()))
                .map(s -> Event.valueOf(s[3].split(" ")[0]))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return getSplitStringsByDate(after, before)
                .stream()
                .filter(s -> s[4].equals(Status.ERROR.toString()))
                .map(s -> Event.valueOf(s[3].split(" ")[0]))
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return (int) getSplitStringsByDate(after, before)
                .stream()
                .filter(s -> s[3].split(" ")[0].equals(Event.SOLVE_TASK.toString())
                        && Integer.parseInt(s[3].split(" ")[1]) == task)
                .count();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return (int) getSplitStringsByDate(after, before)
                .stream()
                .filter(s -> s[3].split(" ")[0].equals(Event.DONE_TASK.toString())
                        && Integer.parseInt(s[3].split(" ")[1]) == task)
                .count();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        return getSplitStringsByDate(after, before)
                .stream()
                .filter(s -> s[3].split(" ")[0].equals(Event.SOLVE_TASK.toString()))
                .collect(Collectors.groupingBy(o -> Integer.parseInt(o[3].split(" ")[1]),
                        Collectors.summingInt(value -> 1)));

    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        return getSplitStringsByDate(after, before)
                .stream()
                .filter(s -> s[3].split(" ")[0].equals(Event.DONE_TASK.toString()))
                .collect(Collectors.groupingBy(o -> Integer.parseInt(o[3].split(" ")[1]),
                        Collectors.summingInt(value -> 1)));
    }

    @Override
    public Set<Object> execute(String query) {
        switch (query) {
            case "get ip":
                return new HashSet<>(getUniqueIPs(null, null));
            case "get user":
                return new HashSet<>(getAllUsers());
            case "get date":
                return getSplitStringsByDate(null, null)
                        .stream()
                        .map(s -> getDate(s[2]))
                        .collect(Collectors.toSet());
            case "get event":
                return getSplitStringsByDate(null,null)
                        .stream()
                        .map(s->Event.valueOf(s[3].split(" ")[0]))
                        .collect(Collectors.toSet());
            case "get status":
                return getSplitStringsByDate(null,null)
                        .stream()
                        .map(s->Status.valueOf(s[4]))
                        .collect(Collectors.toSet());
        }
        return null;
    }
}