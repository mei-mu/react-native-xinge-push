#
#  Be sure to run `pod spec lint XingePush.podspec' to ensure this is a
#  valid spec and to remove all comments including this before submitting the spec.
#
#  To learn more about Podspec attributes see http://docs.cocoapods.org/specification.html
#  To see working Podspecs in the CocoaPods repo see https://github.com/CocoaPods/Specs/
#

Pod::Spec.new do |s|
  s.name         = "XingePush"
  s.version      = "0.5.1"
  s.summary      = "XingePush"

  # This description is used to generate tags and improve search results.
  #   * Think: What does it do? Why did you write it? What is the focus?
  #   * Try to keep it short, snappy and to the point.
  #   * Write the description between the DESC delimiters below.
  #   * Finally, don't worry about the indent, CocoaPods strips it!
  s.description  = <<-DESC
                      XingePush
                   DESC

  s.homepage     = "https://github.com/Jeepeng/react-native-xinge-push"
  s.license      = "MIT"
  s.author             = { "yulin" => "yulin_yl@126.com" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "ssh://git@121.41.95.96:7999/cst/react-native-xinge-push.git", :tag => "v0.5.1" }
  s.source_files  = "**/*.{h,m}"
  s.requires_arc = true

  s.dependency "React"
  s.vendored_libraries = "SDK/libXG-SDK.a"

end
