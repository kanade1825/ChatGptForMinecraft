package net.kanade1825.litematica.chatgptforminecraft;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SetUP implements CommandExecutor {

    private final ChatGPTForMinecraft chatGPTForMinecraft;

    public SetUP(ChatGPTForMinecraft chatGPTForMinecraft) {
        this.chatGPTForMinecraft = chatGPTForMinecraft;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Bukkit.getScheduler().runTaskAsynchronously(chatGPTForMinecraft, () -> {

            Path path = Paths.get("plugins/ChatGPTForMinecraft/TalkData");

            Path path1 = Paths.get("plugins/ChatGPTForMinecraft/CharacterData");

            Path path2 = Paths.get("plugins/ChatGPTForMinecraft/CharacterData/SkinData");

            try {
                if (!Files.exists(path)) {
                    Files.createDirectories(path);
                    commandSender.sendMessage("Directory created at " + path);
                } else {
                    commandSender.sendMessage("Directory already exists at " + path);
                }
            } catch (IOException e) {
                commandSender.sendMessage("Unable to create directory at " + path);
                e.printStackTrace();
            }

            try {
                if (!Files.exists(path1)) {
                    Files.createDirectories(path1);
                    commandSender.sendMessage("Directory created at " + path1);
                } else {
                    commandSender.sendMessage("Directory already exists at " + path1);
                }
            } catch (IOException e) {
                commandSender.sendMessage("Unable to create directory at " + path1);
                e.printStackTrace();
            }

            try {
                if (!Files.exists(path2)) {
                    Files.createDirectories(path2);
                    commandSender.sendMessage("Directory created at " + path2);
                } else {
                    commandSender.sendMessage("Directory already exists at " + path2);
                }
            } catch (IOException e) {
                commandSender.sendMessage("Unable to create directory at " + path2);
                e.printStackTrace();
            }

            String[] filenames = {
                    "EllisTalkData.json",
                    "MarshierTalkData.json",
                    "MiraiTalkData.json",
                    "RaisersTalkData.json",
                    "RasvaanTalkData.json",
                    "RinaTalkData.json",
                    "WagnerTalkData.json"
            };

            String[] filenames2 = {
                    "EllisSkinData.json",
                    "MarshierSkinData.json",
                    "MiraiSkinData.json",
                    "RaisersSkinData.json",
                    "RasvaanSkinData.json",
                    "RinaSkinData.json",
                    "WagnerSkinData.json"
            };


            // 各ファイルに対応する一意の文字列を変数として定義
            String EllisSkinName = "9eef7ed2";
            String EllisSigneture = "lPpKmKKXk4zZlNg+UsNrut5zuLXn9LKUeMDtod1ujdwj5ru/gJCv/mwwe9eJNmcGSypxJCHHVcUTMSWKbsmz4MiK0Mu6327TsFkqUE7eM/Z4wjTh9m/Ma/vexfh7pnPigcP1Zi3bAyOXhU9klla2gutI5mk3vLCWtupDadzFJMvk/DKgK+VA6zU/YHpC6dhs8lVVUhziPPJLuGV4gxPhE0xT7tCnM9Z2H44eJ46hAjQ/BHKGXLz39J7B2baQsU9J3ll5uDBjlaJcNB9Bw8dmu5nB8SPI+QUVM5SxEit6k0OwQmOnXiesXzdeaEhwQBqcSXXZAIvghzy39Aim2cmWqV+ixifwRXbQrqHV5igjE+wEsguegbhqFkMkntPyKwaEt7WOLC9q+yCu6SjyBg04aC4Vs1eSQwBdwLJQG942eVDUphmvdfwRhicujf38CLwX9bt2fnXPidz1mNVcDT6CCcVSfCNXaLYbRXJxRcOwopo0NAp0Dk+SwwmeDkgAN7DukL0a/OUR+g2SwfUmLeXr66zpPPGKAToTkRoWIQAGw8mTk2xZO/PRUaL0RWLkYNoKWAaGHdqvalw8OjgT0E9/XWcWNFlkcFHsdAORJa8ZiNZx9NLki8GTblPdwsP+EnAqNz+0cubuzI7Chff+L2uvjOEt3v0OjiVAb/VNL5LA8Ks=";
            String EllisTextureValue = "ewogICJ0aW1lc3RhbXAiIDogMTY4NTEwNDk3MDc3NCwKICAicHJvZmlsZUlkIiA6ICJkMWYxODM4YjRlMTU0NTk0OGQwMjUwNzNkMzhjNWNjNiIsCiAgInByb2ZpbGVOYW1lIiA6ICJadWthWnVrYW1pIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzQ0NGQ3MzY3Y2MxMGMyMTQzYzEyYjlhNWQxNGMyNzNjZTI0YTIwZjI0MzViMWQ1ZGVlYTNhMjJjYzFiZDI4ZmMiLAogICAgICAibWV0YWRhdGEiIDogewogICAgICAgICJtb2RlbCIgOiAic2xpbSIKICAgICAgfQogICAgfQogIH0KfQ==";

            String MarshierSkinName = "07f289d8";
            String MarshierSigneture = "w2TSxb9DZidokLMvxmkGpureOCr5VyLgIn0hx1PLHAo5XXdz0GIG2wG19jV5LRL8ZT0TPT4LD6NwWu4x6FKcMiRI3K4elhmMg49Qn7DeiffPruS1yB5wftTZAKiZnLsFBfnLnPHWUDmszx6XshDft9aK5LccWENEMWSYEg0xnm60XvuYOVU/qAu/StnW3R2yyi39ODkJUVJUUwRZUA2FB01wBGD0yuqoCh0SRrc166kVJZl1Q/fwUDABuhPwF/vkV4nUFD164/R9tyJHFCS8kSsZa+kmAfJJYG1WEIc2Ks1C3GvMnzixQy2tyhqNVl3UrgQ9N3sW9c1EJqAaVizQPqSy5wWXuF2oqZsJWF9Qk2SkxGj6PgfpsTNmSYXlSs1fq9BQruIvgI3sFUYknCmntCCeMqXTXSbKk8phYT8T+pglzym7S/f3rtfTMU+lfB47xPCRCHohU/R+uqcDYBwqInX1HeRcO/56uR3tqW2heg0UZekjPmcBJxmpJ760Np9fcD4zzrpQQIzEa3XisgwcoYre1oMmzX3OM/X7iFkp4zI2RgOrZ0RdrY3mc7BdxCX0idme9YubwWI1+FaSBeFN7ZuWCbNUf8Ksj5B0XeFqrtTh27CVCD+uyg+K/N8uHCKDUJHNCSONW3KRmgVwdjVhYAjGZQM19wOEp0A4rRubkLs=";
            String MarshierTextureValue = "ewogICJ0aW1lc3RhbXAiIDogMTY4NTEwOTU2MjcwOCwKICAicHJvZmlsZUlkIiA6ICI1YjFiZGQxNDU1MzU0MmM3ODQ5MTMzY2VmODJmMWYwNiIsCiAgInByb2ZpbGVOYW1lIiA6ICJnaW5hdGV0ZXN0IiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzViNmJlZDZhOTcxY2Y4YjhjNzcxYjk0NWRhZGY0YWZhZTkwNTFhOTEwMzM5N2Y2YzAzYjZkNzQ1YzNiNzg2OGUiLAogICAgICAibWV0YWRhdGEiIDogewogICAgICAgICJtb2RlbCIgOiAic2xpbSIKICAgICAgfQogICAgfQogIH0KfQ==";

            String MiraiSkinName = "c6b04ce7";
            String MiraiSigneture = "PcgztAFUxN4/DEnC5Qbu5bXLRqLUSEdSyksLhDM5LKR4C6JtqaFy1zfln29fD1jN+hEuyi+N57LnkdtpcS70mzL+TuR0j7PcndBLufKPzGwoRAbhm/MjNUAQA8QxrFdiuxqhiU8SDc7TuOzz3AbqE0Sk/0cfmlmg+bgVGTZ3u0QAptc5cJhBn9pjOBSKBT5cysZSh87/+Nc49fZRD/2pHwvhn2+MQ19F73JDvf+W6fHxOFb0dEV+PEeZ1swWGDQt4US2Nc6fokc8lnIJT1jIs56ThpwAp074wYcVssHIou/PD5frGzAOhRkVunBPe0zZGnlsY1Ck1XICpgTm8vLhYWEP3Wz4L322+jPOn0wX50fPGVZxvKyL3qCXJtkqG5h3Cd8He0w8coKAtNkjNRPqrlEWwv2JMtHIyD8GZqoWcU6YfSPMnYlhGkQbcKMHwZSHM/6IwzGtO+dAawLhoJrri+/6BbJrMseLQZujRxnq/VDT6MTiLtOiPMudcWRT/B0nBX7IKBK93CTKuzny9iN07UpUcpji/yQf6iywf7Xch9qKIVTYwEt2ByCbjAsbbIkqznvaTTQDAGjsbgyTQYCviuX88XniUVwAnsafkXU32o3niFvG/b0SreaoLEhcdJESfsxa26FnhVaIzTOYj1dgtFrZZ+u33hszduC3ofYc12k=";
            String MiraiTextureValue = "ewogICJ0aW1lc3RhbXAiIDogMTY4NTEwNzgyODU4MywKICAicHJvZmlsZUlkIiA6ICIwOWQ3YmJjNGYxZmU0ZjlkYjRiZmE1MTY2NDA3OTcyYiIsCiAgInByb2ZpbGVOYW1lIiA6ICJlemtkIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzdjZjIxYzlkYzMyZmI3ZjFhMGY2YTQ4OGY5ZWEzZDEyMTY0ZjY0MmIwMWIzMjQ4NWQyNDFiODRiOTc5YjlmODYiCiAgICB9CiAgfQp9";

            String RaisersSkinName = "e634711a";
            String RaisersSigneture = "NvHg5MEvTUX46S5FrJeYnWqdTH44+QBHQzn9bLGKXEfP+zFxW6rusdNywFuy3xxeyyH0iIBPKL5IxG4KI0BnIQB098dDB/tczNIrGVGMXPSs7QmjSuiUz8g44MwzURnPFy3+jkKOdrTqRNiSL6/zsd23ahD4Drj+dos682jjhu/y2whmZwidowWbdybXTQK2fxt99i4Th7Fv4croemJf2sft0tntKpHiylE2jdLMg4MDButW3y0Z15B5AIY6DhEl4tzg2zE72c4byIggeQUm+SPXxDFpODsYzsGs89lSi/9nrlkWFqR73DO1XIbNMWNDRbVyNsDwwtPZpk/hDcVMtvL0T17iw0ZO3jLWPKANtwpA+sSXGKBHFaUZzPJnMRONPQl97VMi/GTUUspw5Ae1xrGlc36xV08rTGNRJXsjUD9he6P+oDKU0b9Ufv0bMcb9WihHYOb+L7A8i39o9YRjTWpYJosCYvfetmyU7SLEzr4XdTIAa5cZMEVezQ9b/qHQKVzZigjWZ6KojHEgXwGCbSllE3R0kijQnR6zdV7/aW+xGs7bVLzt4CkNEn7sG4laPvzZrL/7AJbMd6mtsDnmmcSlacHgY7lglZ/rFSSEGlqG9QLqHzizYapG1x/PuAcAv61JtkhB6O7W1O4rNX0jXk+P22XP2qILwIycPKC0sVQ=";
            String RaisersTextureValue = "ewogICJ0aW1lc3RhbXAiIDogMTY4NTEwNzU2NDQ1NCwKICAicHJvZmlsZUlkIiA6ICJmY2ZhYTg0MzA0YjE0NDUxOThkNWYxNzQ3ZjI0Y2Q5MCIsCiAgInByb2ZpbGVOYW1lIiA6ICJTdGV3eVdvbGZ5IiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzE2ODk2YTU2NDcwNGQzMDc5ZWRlZDM0OGY5NjJmYmE3MjMyMTM1ZTdjYTU2MTAxNTE2OTRlZjI5NTY2YWMwYSIKICAgIH0KICB9Cn0=";

            String RasvaanSkinName = "cfd8a97e";
            String RasvaanSigneture = "T50MVOoY/ELhomiivR7ISOEVlg20wbSa7usk5l2pFPg1lauFu3QuWD9h7TDfGSaFQX/kuGRdgK1NB5H7qQx/2K1+KIsqwVb6goJ4CZdHWb+WWskCCTqei2+6V4JqObDFfsJbgzeiEmUe8uI5Cby5cM2nCSufG5KS1fBVvpYqXCfR8f6hKIRXxxFEvyPTls47LKl+5Xg/WPQ4uJ9Usveea9a7ElXWhy2Hs225Bj1gjHjEiVjS3ns1rHic2NSjjTmUmhmiU2Ij3PRyxPsirhppTd2lD4RF+JfAuJNd+RzCZOC5h4kv+7jWMnCaXkkBKyQ74K7U2Ws9gcURqzK+bQd94QxRNEucVLO9T9i9E+xeMa3IALFvYQCNQZGCsuLCRrdobZlOLoFlxh+eeldkpcEZM6MRd5FbxxvLa6SyCKb10b/APZBIa0anfWf+lTuBT4RBaKGuhSu8nza748sn5H6HuFz6MormzQXHPJX9KCLiGbu/Mn5L8rMDFL973LcaNA4W570H0AkKWAqKy4O1hCtvnRTYl+AAfwKVWE3MIXHZ3OhnmPm5BCSQvKuLYInAmgzicN4445z/aBDmJNNgQKu9j3A6AJef/g1nGe7erfmVqOVHn7otITobw8nOjFhwnzgAAMQzuEzpZ1KUb+YZkB9Us+m/ssRNSYa197UHpsIJjXA=";
            String RasvaanTextureValue = "ewogICJ0aW1lc3RhbXAiIDogMTY4NTEwMzQxMTI5MSwKICAicHJvZmlsZUlkIiA6ICJiNzQ4YWExODk3ZGU0Y2RiYjFhNTI1YjVjMjM3ZDc2MiIsCiAgInByb2ZpbGVOYW1lIiA6ICJUaXhpOCIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS85ZTJjNDQ5MjE2MWMyZDAzNTVhMzdjOTU5ZmMzYzE1MjMyMzU1MTcyMDkxYzY0MTU5MTY4NGIwM2ZhYzhjZDNjIiwKICAgICAgIm1ldGFkYXRhIiA6IHsKICAgICAgICAibW9kZWwiIDogInNsaW0iCiAgICAgIH0KICAgIH0KICB9Cn0=";

            String RinaSkinName = "5c137554";
            String RinaSigneture = "BqSEPK/+nC0wHXXBSp3D6dRDziBT95wxbP9xCEesi8k4wb0H2OPX+noSd3jbLeDgVWnYHsvYXs1b9KaosZmY59IHhuufv1fcNKegMjuxRCjaeEiBeY7DK3YTarDlVj0TOXPidNpptbEz3UGY3uIb0AR/xL419Hfyl3mGvYJ1M3v8UA2EKFh6Z+hBeUbquXJIJnm6vfvRoWtWxIMgTGMjMR8pUtmvbBxGQKXWQCw1gA4mXnS7qSVvZ4F7pR94+X/PI8bzw1liSLuYRI+nrjbHyAtxU9oc8grMkCEMBDNuy0ZZH0GM3oIGDGTa5/TDuGmLi0OFX+GN+BGwPTW4lqTsOgTbKeFP77Z/csn0LOR0b+gownsqQtNHg2P7pnZ7dmK12Cq4ddmNjPQqTnzDXsxlhQMfEx0nPhXuWabskAaNBV4p9A4H6duw5QkCrQaPGz073RXbulzkVi1X1eI/Et+uZ1/t3xeaVB/5pQhRH8M4tK5lnraDht0GKsD74XcL0T+YszOGBItEAubjRza4BqnFjZc9GV7gKHtwe4WUrWhvc2L7gR1jKupb0V0bp5eug8eu7Yz4NT5lOuxfNm8rlcV0OiN1M5lvZmpaghp63kdipeGsp6rgzr1zstvh56GYW1d9BMXSh31j1yDUE0Lz7AjGuJuaRtvpkN6Mlza7NZt1AjU=";
            String RinaTextureValue = "ewogICJ0aW1lc3RhbXAiIDogMTY4NTEwMjE4MDY0NSwKICAicHJvZmlsZUlkIiA6ICI4N2YzOGM1MWE4Yzc0MmNmYTY2YTgxNWExZTI2NzMzYiIsCiAgInByb2ZpbGVOYW1lIiA6ICJCZWR3YXJzQ3V0aWUiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTliMmRlOTAxMmM3NmNlNTJlYWFlNWZjNTY5YjhhYjVkNTNkNDgwNTRkNzNjYzYxNjdkNTA2OWY5NjJiZTY3IiwKICAgICAgIm1ldGFkYXRhIiA6IHsKICAgICAgICAibW9kZWwiIDogInNsaW0iCiAgICAgIH0KICAgIH0KICB9Cn0=";

            String WagnerSkinName = "33699de4";
            String WagnerSigneture = "H5mAapyekMdYs8yWva/qXLmFug7UGSr71pLNlG8OaKZVD+GK0PFpnjW266Dn0ud/9i95mjrJcqWVsjn9Pbpbi5WV6xwU6TmcQvOEXUX5tVhkZ7ePH73mXnza5gU2W8H1LrJReX3AYXHwDwgCGzsB4LWZIvPTg72P0IkycnISPzcMnwK0LI0DiFt3k8mFgEuX54Uq7WAfO/SJETbBk86zpSg/ZnRGo2QszGzcSzuaRt0h021bFR41f7LCmfnixkm0A461j4ZhDO9KRcCV/H7uCuHQ5xKdQKsddett19lk0mojIxBjbPcFU4jdoNARwAN8I75WpQXBOQrDMeeAPwmI/0fqvWa4NQVX5klH1286iWebWcCrirNYChojESvnygYHwlbvZ0m7ZmcNWvYrUd1mVf3kwgzzjRUZWgwMG5JLf6md/iWMkEJaBWsZrziBA3jhigMP7Yz/M8fjX8hLUUqvkAqNorX6mrUskXGXfYY5fIwjwaQk5jT0tXhRQW+RXioUaJIMdtjmV5xKu0oyXGNDYG58qFppjNNL8erZQ2kHZoFLi8qOa406s6USYEb+b13bBh8ZYL2O8QKs4TkzPPhaipRImHR+AslwEFWWOCeW5ErRRHd1CcNFETaRfEHWeNd+prXPPgQ12IU8TdECorQQFdoBDrSJJSdJ9lGdioe+bVY=";
            String WagnerTextureValue = "ewogICJ0aW1lc3RhbXAiIDogMTY4NTA0ODg3Nzc2MywKICAicHJvZmlsZUlkIiA6ICI5NTE3OTkxNjljYzE0MGY1OGM2MmRjOGZmZTU3NjBiZCIsCiAgInByb2ZpbGVOYW1lIiA6ICJZdWFyaWciLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWM4NGNmOTkzYTZkMDczNDJjYjA4NGEwOTQ2YTJmNDY5MDAzMjg4ZjkxODk4YzZjNDc5NWZlMWJlNzExMWM4YiIKICAgIH0KICB9Cn0=";

            for (String filename : filenames) {
                try {
                    // ファイルパスを作成
                    File file = new File(path.toFile(), filename);

                    // ディレクトリが存在しない場合は作成
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }

                    // FileWriterオブジェクトを作成して空のJSONファイルを生成
                    FileWriter fileWriter = new FileWriter(file);

                    // 空のJSONオブジェクトを書き込み
                    fileWriter.write("{}");

                    // ファイルを閉じる
                    fileWriter.close();

                    commandSender.sendMessage(filename + " was created.");

                } catch (IOException e) {
                    commandSender.sendMessage("An error occurred while creating " + filename);
                    e.printStackTrace();
                }
            }
            for (String filename : filenames2) {
                try {
                    // ファイルパスを作成
                    File file = new File(path2.toFile(), filename);

                    // ディレクトリが存在しない場合は作成
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }

                    // FileWriterオブジェクトを作成して空のJSONファイルを生成
                    FileWriter fileWriter = new FileWriter(file);

                    // JSONオブジェクトを作成し、各フィールドに一意の文字列を設定
                    JSONObject jsonObject = new JSONObject();
                    if (filename.equals("EllisSkinData.json")) {
                        jsonObject.put("SkinName", EllisSkinName);
                        jsonObject.put("Signeture", EllisSigneture);
                        jsonObject.put("TextureValue", EllisTextureValue);
                    } else if (filename.equals("MarshierSkinData.json")) {
                        jsonObject.put("SkinName", MarshierSkinName);
                        jsonObject.put("Signeture", MarshierSigneture);
                        jsonObject.put("TextureValue", MarshierTextureValue);
                    } else if (filename.equals("MiraiSkinData.json")) {
                        jsonObject.put("SkinName", MiraiSkinName);
                        jsonObject.put("Signeture",MiraiSigneture);
                        jsonObject.put("TextureValue", MiraiTextureValue);
                    } else if (filename.equals("RaisersSkinData.json")) {
                        jsonObject.put("SkinName", RaisersSkinName);
                        jsonObject.put("Signeture", RaisersSigneture);
                        jsonObject.put("TextureValue", RaisersTextureValue);
                    } else if (filename.equals("RasvaanSkinData.json")) {
                        jsonObject.put("SkinName", RasvaanSkinName);
                        jsonObject.put("Signeture", RasvaanSigneture);
                        jsonObject.put("TextureValue", RasvaanTextureValue);
                    } else if (filename.equals("RinaSkinData.json")) {
                        jsonObject.put("SkinName", RinaSkinName);
                        jsonObject.put("Signeture", RinaSigneture);
                        jsonObject.put("TextureValue", RinaTextureValue);
                    } else if (filename.equals("WagnerSkinData.json")) {
                        jsonObject.put("SkinName", WagnerSkinName);
                        jsonObject.put("Signeture", WagnerSigneture);
                        jsonObject.put("TextureValue", WagnerTextureValue);
                    }

                    // JSONオブジェクトをファイルに書き込み
                    fileWriter.write(jsonObject.toString());

                    // ファイルを閉じる
                    fileWriter.close();

                    commandSender.sendMessage(filename + " was created.");

                } catch (IOException e) {
                    commandSender.sendMessage("An error occurred while creating " + filename);
                    e.printStackTrace();
                }
            }


        });


        return false;
    }
}
